package com.rahmitufanoglu.roomdatabase.java;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.rahmitufanoglu.roomdatabase.java.User;

import java.util.List;

@Dao
public interface UserDao2 {

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    //@Query("SELECT email FROM users WHERE firstname = :firstname")
    //List<User> findUserEmail(String... users);

    @Query("SELECT COUNT(*) from users")
    int countUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllUsers(User... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Update
    int updateUser(User user);

    @Query("DELETE FROM users")
    void deleteAllUsers();

    @Delete
    void deleteUsers(User... users);
}