package com.example.aplikasiobengkel.data.database

import android.content.Context
import androidx.room.*
import com.example.aplikasiobengkel.data.database.dao.UserDao
import com.example.obengkel_application.data.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class OBengkelDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {
        @Volatile
        private var INSTANCE: OBengkelDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): OBengkelDatabase {
            if (INSTANCE == null) {
                synchronized(OBengkelDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        OBengkelDatabase::class.java, "db_workshop")
                        .build()
                }
            }
            return INSTANCE as OBengkelDatabase
        }
    }
}