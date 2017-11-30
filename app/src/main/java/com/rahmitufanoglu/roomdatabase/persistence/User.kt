package com.rahmitufanoglu.roomdatabase.java

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
class User(@field:ColumnInfo(name = "firstname")
           var firstname: String?,
           @field:ColumnInfo(name = "lastname")
           var lastname: String?,
           @field:ColumnInfo(name = "email")
           var email: String?) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}