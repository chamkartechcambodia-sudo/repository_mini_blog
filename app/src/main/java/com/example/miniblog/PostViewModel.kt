package com.example.miniblog

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Step 1 — NO repository yet.
 *
 * This ViewModel talks DIRECTLY to BOTH data sources: the network [ApiService] AND the Room
 * [PostDao]. Notice how much it has to know — how to fetch, how to store, and where the
 * database comes from. Mixing those responsibilities into the ViewModel is exactly the
 * problem the Repository pattern will fix in the next step.
 *
 * It extends AndroidViewModel only to get the Application context needed to open Room.
 */
class PostViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getInstance(application).postDao()
    private val api = RetrofitClient.api

    /** The UI observes this. Single source of truth = Room. */
    val posts: LiveData<List<Post>> = dao.getAllPosts()

    /** Fetch from the network, then save into Room. The LiveData above then updates by itself. */
    fun refresh() {
        viewModelScope.launch {
            try {
                val fetched = api.getPosts()
                dao.insertPosts(fetched)
            } catch (e: Exception) {
                // Minimal handling for the lesson; a real app would surface this to the user.
                e.printStackTrace()
            }
        }
    }
}
