package com.example.miniblog

import android.app.Application

/**
 * Step 4 — the composition root now builds the CONCRETE [DefaultPostRepository] but exposes it
 * through the [PostRepository] interface type. The production wiring is otherwise unchanged; the
 * point is that everything depending on `repository` now depends on the abstraction — which is
 * what lets tests substitute a fake. Manual DI, no Hilt.
 */
class MiniBlogApplication : Application() {

    val database by lazy { AppDatabase.getInstance(this) }

    val repository: PostRepository by lazy {
        DefaultPostRepository(RetrofitClient.api, database.postDao())
    }
}
