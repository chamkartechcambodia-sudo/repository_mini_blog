package com.example.miniblog

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

/**
 * Step 4 — because PostViewModel depends on the PostRepository INTERFACE, we can hand it a
 * [FakePostRepository] and test it as a plain JVM unit test: no emulator, no network, no Room.
 */
class PostViewModelTest {

    // Lets LiveData run synchronously on the test thread instead of the Android main thread.
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun viewModel_exposesPostsFromRepository() {
        val fake = FakePostRepository()
        val viewModel = PostViewModel(fake)

        // Observe so the LiveData is active, then push data in through the fake repository.
        viewModel.posts.observeForever { }
        val sample = listOf(
            Post(id = 1, userId = 1, title = "Hello", body = "World")
        )
        fake.postsData.value = sample

        assertEquals(sample, viewModel.posts.value)
    }
}
