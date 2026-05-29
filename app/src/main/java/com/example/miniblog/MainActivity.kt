package com.example.miniblog

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // Step 3: construction now lives in MiniBlogApplication (the repository) and
    // PostViewModelFactory (the ViewModel). The Activity just asks the factory for a ViewModel
    // built from the app-wide repository — clean and reusable.
    private val viewModel: PostViewModel by viewModels {
        PostViewModelFactory((application as MiniBlogApplication).repository)
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
