package com.example.miniblog

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A single blog post.
 *
 * TEACHING SIMPLIFICATION: this ONE class plays two roles at once —
 *   1) a Room @Entity (a row in the local database), and
 *   2) the Retrofit response model (the JSON shape returned by the API).
 *
 * In a real app you would usually split these into a separate DTO (network model)
 * and Entity (database model). That DTO/Entity separation is a LATER topic; for now
 * one class keeps the lesson focused on the Repository pattern.
 *
 * JSON from https://jsonplaceholder.typicode.com/posts looks like:
 *   { "userId": 1, "id": 1, "title": "...", "body": "..." }
 */
@Entity(tableName = "posts")
data class Post(
    @PrimaryKey val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)
