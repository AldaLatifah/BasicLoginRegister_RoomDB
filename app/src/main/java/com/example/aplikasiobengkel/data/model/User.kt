package com.example.aplikasiobengkel.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey var id: Int,
    var name: String,
    var username: String,
    var telp: String,
    var email: String,
    var password: String,
)

//@Entity(tableName = "tb_user")
//@Parcelize
//data class User(
//    @PrimaryKey(autoGenerate = true)
//    var id: Int = 0,
//
//    @ColumnInfo(name = "name")
//    var name:String,
//
//    @ColumnInfo(name = "username")
//    var username:String,
//
//    @ColumnInfo(name = "telp")
//    var telp:String,
//
//    @ColumnInfo(name = "email")
//    var email:String,
//
//    @ColumnInfo(name = "password")
//    var password:String,
//) : Parcelable
