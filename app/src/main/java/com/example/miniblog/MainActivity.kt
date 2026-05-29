package com.example.miniblog

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // Step 2: we extracted a PostRepository, but the slim PostViewModel now needs it in its
    // constructor. Without a factory the framework can't build it, so for now we wire it BY
    // HAND with an inline factory. This is a bit clunky and leaks construction details into the
    // Activity — step 3 cleans it up with a dedicated ViewModelFactory + an Application that
    // owns the database.
    private val viewModel: PostViewModel by viewModels {
        val dao = AppDatabase.getInstance(applicationContext).postDao()
        val repository = PostRepository(RetrofitClient.api, dao)
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T =
                PostViewModel(repository) as T
        }
    }

    private val adapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.postsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.posts.observe(this) { posts ->
            adapter.updatePosts(posts)
        }

        findViewById<Button>(R.id.refreshButton).setOnClickListener {
            viewModel.refresh()
        }
    }
}
