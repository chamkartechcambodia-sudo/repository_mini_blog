package com.example.miniblog

import androidx.lifecycle.LiveData

/**
 * Step 2 — the Repository.
 *
 * It now OWNS the data sources (network [ApiService] + database [PostDao]) and exposes a
 * clean, intention-revealing API to the rest of the app: read [posts], or ask to [refresh].
 * The ViewModel no longer needs to know HOW data is fetched or stored.
 */
class PostRepository(
    private val api: ApiService,
    private val dao: PostDao
) {
    /** Single source of truth = Room. */
    val posts: LiveData<List<Post>> = dao.getAllPosts()

    /** Fetch from the network, then save into Room. */
    suspend fun refresh() {
        val fetched = api.getPosts()
        dao.insertPosts(fetched)
    }
}
