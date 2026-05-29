package com.example.miniblog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter that turns a List<Post> into RecyclerView rows.
 *
 * RecyclerView refresher (read top to bottom):
 *   • ViewHolder         = holds the views for ONE row, so we don't call findViewById repeatedly.
 *   • onCreateViewHolder = inflate item_post.xml into a new ViewHolder (called only a few times).
 *   • onBindViewHolder   = put a specific Post's data into an existing row (called a lot).
 *   • getItemCount       = how many rows in total.
 */
class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var posts: List<Post> = emptyList()

    /**
     * Replace the whole list and redraw.
     * (We use notifyDataSetChanged() to keep things simple here; DiffUtil is a later
     * optimization once students are comfortable with the basics.)
     */
    fun updatePosts(newPosts: List<Post>) {
        posts = newPosts
        notifyDataSetChanged()
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.titleText)
        val bodyText: TextView = itemView.findViewById(R.id.bodyText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.titleText.text = post.title
        holder.bodyText.text = post.body
    }

    override fun getItemCount(): Int = posts.size
}
