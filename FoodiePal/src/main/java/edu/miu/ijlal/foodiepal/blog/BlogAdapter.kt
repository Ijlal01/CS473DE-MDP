package edu.miu.ijlal.foodiepal.blog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.miu.ijlal.foodiepal.R

class BlogAdapter(private val blogPosts: List<BlogPost>) : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_blog_post, parent, false)
        return BlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val blogPost = blogPosts[position]
        holder.bind(blogPost)
    }

    override fun getItemCount(): Int {
        return blogPosts.size
    }

    class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)
        private val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
        private val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)

        fun bind(blogPost: BlogPost) {
            titleTextView.text = blogPost.title
            contentTextView.text = blogPost.content
            authorTextView.text = blogPost.author
            dateTextView.text = blogPost.date
        }
    }
}
