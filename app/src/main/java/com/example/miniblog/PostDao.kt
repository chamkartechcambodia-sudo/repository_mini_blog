package com.example.miniblog

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Data Access Object for [Post] rows.
 *
 * The query method returns [LiveData] so the UI can OBSERVE the database: whenever the
 * "posts" table changes, Room re-runs the query and pushes a fresh list to observers.
 * This is the heart of "single source of truth = Room".
 *
 * (This course uses LiveData on purpose — Kotlin Flow is intentionally NOT used.)
 */
@Dao
interface PostDao {

    /** Observe every post. Room pushes a new list automatically whenever the table changes. */
    @Query("SELECT * FROM posts ORDER BY id ASC")
    fun getAllPosts(): LiveData<List<Post>>

    /** Insert a batch of posts, replacing any with the same id (used after a network fetch). */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<Post>)
}
