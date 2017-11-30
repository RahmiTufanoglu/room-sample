package com.rahmitufanoglu.roomdatabase.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rahmitufanoglu.roomdatabase.R;

public class CreateUserActivity2 extends AppCompatActivity implements View.OnClickListener {

    private EditText etFirstname;
    private EditText etLastname;
    private EditText etEmail;
    private Button btnAddUser;
    private Button btnDeleteUser;
    private Button btnDeleteAllUsers;
    private Button btnFindUserEmail;
    private TextView tvUserCount;
    private UserDatabase2 database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        etFirstname = findViewById(R.id.tiet_firstname);
        etLastname = findViewById(R.id.tiet_lastname);
        etEmail = findViewById(R.id.tiet_email);
        btnAddUser = findViewById(R.id.btn_add_user);
        btnDeleteUser = findViewById(R.id.btn_delete_user);
        btnDeleteAllUsers = findViewById(R.id.btn_delete_all_users);
        btnFindUserEmail = findViewById(R.id.btn_find_user_email);
        tvUserCount = findViewById(R.id.tv_user_count);

        database = UserDatabase2.getInstance(this);

        tvUserCount.setText(String.format(String.valueOf(database.userDao().countUsers())));
        btnAddUser.setOnClickListener(this);
        btnDeleteUser.setOnClickListener(this);
        btnDeleteAllUsers.setOnClickListener(this);
        btnFindUserEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String firstName = etFirstname.getText().toString();
        String lastName = etLastname.getText().toString();
        String email = etEmail.getText().toString();

        switch (v.getId()) {
            case R.id.btn_add_user:
                database.userDao().insertUser(new User(firstName, lastName, email));
                startActivity(new Intent(CreateUserActivity2.this, MainActivity2.class));
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.btn_delete_user:
                // TODO: 29.11.2017  database.userDao().deleteUser();
                //startActivity(new Intent(CreateUserActivity2.this, MainActivity2.class));
                //overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.btn_delete_all_users:
                database.userDao().deleteAllUsers();
                startActivity(new Intent(CreateUserActivity2.this, MainActivity2.class));
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                break;
            case R.id.btn_find_user_email:
                // TODO: 29.11.2017  database.userDao().findUserEmail(firstName);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }
}