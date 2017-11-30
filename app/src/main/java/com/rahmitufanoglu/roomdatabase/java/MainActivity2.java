package com.rahmitufanoglu.roomdatabase.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.rahmitufanoglu.roomdatabase.CreateUserActivity;
import com.rahmitufanoglu.roomdatabase.R;

import java.util.List;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fabAddUser;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private UserDatabase2 database;
    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        fabAddUser = findViewById(R.id.fab_add_user);

        setSupportActionBar(toolbar);

        database = UserDatabase2.getInstance(this);
        final List<User> users = database.userDao().getAllUsers();

        adapter = new UserAdapter2(users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fabAddUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add_user:
                startActivity(new Intent(MainActivity2.this, CreateUserActivity.class));
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        final long currentTimeMillis = System.currentTimeMillis();

        if (currentTimeMillis - backPressedTime > 2000) {
            backPressedTime = currentTimeMillis;
            Toast.makeText(this, getString(R.string.reach_homescreen), Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
        }
    }
}