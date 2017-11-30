package com.rahmitufanoglu.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.rahmitufanoglu.roomdatabase.persistence.UserDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var adapter: RecyclerView.Adapter<*>? = null
    private var database: UserDatabase? = null
    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setToolbar()

        database = UserDatabase.getInstance(this)
        val users = database!!.userDao().getAllUsers()

        adapter = UserAdapter(users)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

        fab_add_user.setOnClickListener(this)
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.fab_add_user -> {
                startActivity(Intent(this, CreateUserActivity::class.java))
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out)
            }
            else -> {
            }
        }
    }

    override fun onBackPressed() {
        val currentTimeMillis = System.currentTimeMillis()

        if (currentTimeMillis - backPressedTime > 2000) {
            backPressedTime = currentTimeMillis
            Toast.makeText(this, getString(R.string.reach_homescreen), Toast.LENGTH_SHORT).show()
        } else {
            super.onBackPressed()
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
        }
    }
}