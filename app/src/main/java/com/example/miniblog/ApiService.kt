package com.example.miniblog

import retrofit2.http.GET

/**
 * Retrofit endpoints for the blog API.
 *
 * `suspend` lets us call this from a coroutine (in the ViewModel) without blocking the UI.
 */
interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>
}
