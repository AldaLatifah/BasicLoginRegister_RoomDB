package com.example.aplikasiobengkel.data.database.dao

import androidx.room.*
import com.example.aplikasiobengkel.data.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM user WHERE email = :email")
    suspend fun getUsername(email: String): User
}