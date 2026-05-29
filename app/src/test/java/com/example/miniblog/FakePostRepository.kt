package com.example.miniblog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * A test double for [PostRepository] — no network, no database. A test sets the data directly
 * through [postsData], and can check whether [refresh] was called. This is only possible because
 * PostRepository is an interface (step 4).
 */
class FakePostRepository : PostRepository {

    val postsData = MutableLiveData<List<Post>>()
    var refreshCalled = false

    override val posts: LiveData<List<Post>> get() = postsData

    override suspend fun refresh() {
        refreshCalled = true
    }
}
