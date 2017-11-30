package com.rahmitufanoglu.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.rahmitufanoglu.roomdatabase.java.User
import com.rahmitufanoglu.roomdatabase.persistence.UserDatabase
import kotlinx.android.synthetic.main.activity_create_user.*

class CreateUserActivity : AppCompatActivity(), View.OnClickListener {

    private var database: UserDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        database = UserDatabase.getInstance(this)

        tv_user_count.text = String.format(database!!.userDao().countUsers().toString())
        btn_add_user.setOnClickListener(this)
        btn_delete_user.setOnClickListener(this)
        btn_delete_all_users.setOnClickListener(this)
        btn_find_user_email.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val firstName = tiet_firstname.text.toString()
        val lastName = tiet_lastname.text.toString()
        val email = tiet_email.text.toString()

        when (view.id) {
            R.id.btn_add_user -> {
                database!!.userDao().insertUser(User(firstName, lastName, email))
                startActivity(Intent(this, MainActivity::class.java))
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
            }
            R.id.btn_delete_user -> {
                // TODO: 29.11.2017  database.userDao().deleteUser();
                //startActivity(new Intent(CreateUserActivity2.this, MainActivity2.class));
                //overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            }
            R.id.btn_delete_all_users -> {
                database!!.userDao().deleteAllUsers()
                startActivity(Intent(this, MainActivity::class.java))
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
            }
            R.id.btn_find_user_email -> {
                // TODO: 29.11.2017  database.userDao().findUserEmail(firstName);
            }
            else -> {
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
    }
}