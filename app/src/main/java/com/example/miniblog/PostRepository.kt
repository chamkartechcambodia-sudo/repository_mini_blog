package com.example.miniblog

import androidx.lifecycle.LiveData

/**
 * Step 4 — PostRepository is now an INTERFACE: the abstraction the ViewModel depends on.
 *
 * Production code uses [DefaultPostRepository]; tests can swap in a fake implementation. This
 * is exactly what makes the ViewModel unit-testable without Android, the network, or Room.
 */
interface PostRepository {
    val posts: LiveData<List<Post>>
    suspend fun refresh()
}
