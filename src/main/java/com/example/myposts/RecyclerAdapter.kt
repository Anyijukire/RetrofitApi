package com.example.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var postList : List<Post>, var context: Context): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView= LayoutInflater.from(parent.context)
                .inflate(R.layout.item_display_file,parent,false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = postList.get(position)
        holder.tvName.text=currentPost.title
        holder.tvBody.text=currentPost.body
        holder.cvPosts.setOnClickListener {
            var intent = Intent(context, ViewPostActivity::class.java)
            intent.putExtra("POST_ID", currentPost.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
return postList.size
    }
}
class PostViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
    var cvPosts=itemView.findViewById<CardView>(R.id.cvPosts)
}