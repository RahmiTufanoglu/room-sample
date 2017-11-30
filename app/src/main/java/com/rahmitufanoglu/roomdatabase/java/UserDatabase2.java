package com.rahmitufanoglu.roomdatabase.java;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase2 extends RoomDatabase {

    private static UserDatabase2 INSTANCE;

    public abstract UserDao2 userDao();

    public static UserDatabase2 getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UserDatabase2.class, "User.db")
                    .allowMainThreadQueries() // TODO: 29.11.2017: bad practise -> RxAndroid
                    .build();
        }
        return INSTANCE;
    }
}