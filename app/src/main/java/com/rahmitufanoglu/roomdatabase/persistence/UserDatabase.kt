package com.rahmitufanoglu.roomdatabase.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.rahmitufanoglu.roomdatabase.java.User

@Database(entities = [(User::class)], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "User.db")
                        .allowMainThreadQueries() // TODO: 29.11.2017: bad practise -> RxAndroid
                        .build()
            }
            return INSTANCE!!
        }
    }
}