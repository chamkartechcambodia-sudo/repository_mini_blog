package com.example.miniblog

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Step 2 — a SLIM ViewModel.
 *
 * It holds a [PostRepository] and simply delegates: expose the repository's data, and ask it
 * to refresh. Compare with step 1's fat AndroidViewModel that juggled the api and dao itself.
 *
 * Because it now takes a PostRepository in its constructor, the default `by viewModels()`
 * factory can no longer build it. For now MainActivity wires it by hand with an inline
 * factory — step 3 replaces that with a proper ViewModelFactory.
 */
class PostViewModel(private val repository: PostRepository) : ViewModel() {

    val posts: LiveData<List<Post>> = repository.posts

    fun refresh() {
        viewModelScope.launch {
            try {
                repository.refresh()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
