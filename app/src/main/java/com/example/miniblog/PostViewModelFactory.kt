package com.example.miniblog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Step 3 — a reusable factory that knows how to build a [PostViewModel] from a
 * [PostRepository]. This replaces the clunky inline factory we wrote inside MainActivity in
 * step 2, keeping construction details out of the Activity.
 */
class PostViewModelFactory(
    private val repository: PostRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        PostViewModel(repository) as T
}
