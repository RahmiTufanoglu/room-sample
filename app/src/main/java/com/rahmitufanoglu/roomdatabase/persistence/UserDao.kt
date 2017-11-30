package com.rahmitufanoglu.roomdatabase.persistence

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

import com.rahmitufanoglu.roomdatabase.java.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("SELECT email FROM users WHERE id = :id")
    fun findUserEmail(vararg users: User): List<User>

    @Query("SELECT COUNT(*) from users")
    fun countUsers(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(vararg users: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User): Int

    @Query("DELETE FROM users")
    fun deleteAllUsers()

    @Delete
    fun deleteUsers(vararg users: User)
}