package com.example.miniblog

import androidx.lifecycle.LiveData

/**
 * Step 4 — the real [PostRepository]: network [ApiService] + Room [PostDao].
 * (Same logic that lived in the concrete PostRepository class before it became an interface.)
 */
class DefaultPostRepository(
    private val api: ApiService,
    private val dao: PostDao
) : PostRepository {

    override val posts: LiveData<List<Post>> = dao.getAllPosts()

    override suspend fun refresh() {
        val fetched = api.getPosts()
        dao.insertPosts(fetched)
    }
}
