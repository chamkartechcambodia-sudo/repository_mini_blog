package com.example.miniblog

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * The Room database — the app's SINGLE SOURCE OF TRUTH.
 *
 * exportSchema = false keeps this teaching project simple (no schema JSON files and no
 * extra Gradle plugin). A production app usually exports schemas to support migrations.
 */
@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /** Thread-safe singleton so the whole app shares ONE database instance. */
        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "miniblog.db"
                ).build().also { INSTANCE = it }
            }
    }
}
