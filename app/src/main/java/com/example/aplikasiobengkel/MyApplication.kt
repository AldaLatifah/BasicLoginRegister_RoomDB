package com.example.aplikasiobengkel

import android.app.Application
import com.example.aplikasiobengkel.data.database.OBengkelDatabase

class MyApplication : Application() {
    private val database by lazy { OBengkelDatabase.getDatabase(this) }
}