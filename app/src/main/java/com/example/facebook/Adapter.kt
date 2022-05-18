package com.example.facebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook.app.dto.Posts

class Adapter(val user: MutableList<Posts>) : RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_view, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return holder.bindView(user[position])
    }

    override fun getItemCount(): Int {
        return user.size
    }
}

class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val id: TextView = itemView.findViewById(R.id.userid)
    private val email: TextView = itemView.findViewById(R.id.email)
    private val firstName: TextView = itemView.findViewById(R.id.firstName)
    private val lastName: TextView = itemView.findViewById(R.id.lastName)

    fun bindView(user: Posts){
        id.text = user.id.toString()
        email.text = user.userId.toString()
        firstName.text = user.title
        lastName.text = user.body
    }
}