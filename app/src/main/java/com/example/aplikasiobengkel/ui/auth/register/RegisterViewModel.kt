package com.example.aplikasiobengkel.ui.auth.register

import android.app.Application
import androidx.lifecycle.*
import com.example.aplikasiobengkel.data.repository.UserRepository
import com.example.obengkel_application.data.model.User
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : ViewModel() {

    private val repository: UserRepository = UserRepository(application)

    fun register(accounts: User) {
        viewModelScope.launch {
            repository.insert(accounts)
        }
    }

}