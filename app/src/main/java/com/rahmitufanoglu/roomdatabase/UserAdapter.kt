package com.rahmitufanoglu.roomdatabase

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import com.rahmitufanoglu.roomdatabase.java.User
import kotlinx.android.synthetic.main.user_row.view.*

class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.firstname.text = userList[position].firstname
        holder.lastname.text = userList[position].lastname
        holder.email.text = userList[position].email
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var firstname: TextView = itemView.tv_firstname
        var lastname: TextView = itemView.tv_lastname
        var email: TextView = itemView.tv_email
    }
}