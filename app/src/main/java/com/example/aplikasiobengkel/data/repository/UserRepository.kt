package com.example.aplikasiobengkel.data.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.aplikasiobengkel.MyApplication
import com.example.aplikasiobengkel.data.database.OBengkelDatabase
import com.example.aplikasiobengkel.data.database.dao.UserDao
import com.example.obengkel_application.data.model.User
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class UserRepository(application: Application)  {
    private val userDao: UserDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = OBengkelDatabase.getDatabase(application)
        userDao = db.userDao()
    }

    fun insert(user: User) {
        executorService.execute { userDao.insert(user) }
    }

    fun getUsername(email:String) : User? {
        return userDao.getUsername(email)
    }

}