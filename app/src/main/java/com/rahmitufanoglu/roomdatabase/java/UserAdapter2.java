package com.rahmitufanoglu.roomdatabase.java;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.rahmitufanoglu.roomdatabase.R;

import java.util.List;

public class UserAdapter2 extends RecyclerView.Adapter<UserAdapter2.ViewHolder> {

    private List<User> userList;

    public UserAdapter2(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public UserAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter2.ViewHolder holder, int position) {
        holder.firstname.setText(userList.get(position).getFirstname());
        holder.lastname.setText(userList.get(position).getLastname());
        holder.email.setText(userList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView firstname;
        TextView lastname;
        TextView email;

        ViewHolder(View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.tv_firstname);
            lastname = itemView.findViewById(R.id.tv_lastname);
            email = itemView.findViewById(R.id.tv_email);
        }
    }
}