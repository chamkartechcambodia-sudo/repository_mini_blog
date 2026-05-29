package com.example.miniblog

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter that turns a List<Post> into RecyclerView rows.
 *
 * RecyclerView refresher (read top to bottom):
 *   • ViewHolder         = holds the views for ONE row, so we don't call findViewById repeatedly.
 *   • onCreateViewHolder = inflate item_post.xml into a new ViewHolder (called only a few times).
 *   • onBindViewHolder   = put a specific Post's data into an existing row (called a lot).
 *   • getItemCount       = how many rows in total.
 *
 * TODO (Step 1 — branch 01-no-repository): implement the method bodies. The starter leaves
 * them as TODO() so the foundation compiles before we wire networking + the list. (TODO()
 * compiles fine; it just throws if called — and nothing calls it yet in the starter.)
 */
class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    // TODO (Step 1): keep the current list of posts here, plus a function to update it.

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TODO (Step 1): find the title / body views from item_post.xml, e.g.
        //   val titleText: TextView = itemView.findViewById(R.id.titleText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        TODO("Step 1: inflate R.layout.item_post and return a PostViewHolder")
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        TODO("Step 1: bind posts[position] (title + body) into the holder's views")
    }

    override fun getItemCount(): Int {
        TODO("Step 1: return the number of posts")
    }
}
