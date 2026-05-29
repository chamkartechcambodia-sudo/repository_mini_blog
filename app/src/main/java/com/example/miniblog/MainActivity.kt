package com.example.miniblog

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * The single screen of MiniBlog: a list of posts + a Refresh button.
 *
 * PostViewModel is an AndroidViewModel, so the default `by viewModels()` factory can create
 * it (it supplies the Application automatically).
 */
class MainActivity : AppCompatActivity() {

    private val viewModel: PostViewModel by viewModels()
    private val adapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.postsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Observe Room (through the ViewModel). When the posts table changes, redraw the list.
        viewModel.posts.observe(this) { posts ->
            adapter.updatePosts(posts)
        }

        // Tap Refresh -> ViewModel fetches from the network -> saves to Room -> LiveData updates UI.
        findViewById<Button>(R.id.refreshButton).setOnClickListener {
            viewModel.refresh()
        }
    }
}
