package com.example.miniblog

import android.app.Application

/**
 * Step 3 — manual dependency injection (NO Hilt).
 *
 * The Application is the app's "composition root": the ONE place that builds the database and
 * the repository, then holds them for the whole app to share. `by lazy` means each is created
 * the first time it's needed and then reused.
 *
 * Registered in AndroidManifest.xml via android:name=".MiniBlogApplication".
 */
class MiniBlogApplication : Application() {

    val database by lazy { AppDatabase.getInstance(this) }

    val repository by lazy { PostRepository(RetrofitClient.api, database.postDao()) }
}
