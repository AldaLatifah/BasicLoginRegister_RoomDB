package com.example.aplikasiobengkel.ui.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.MyApplication
import com.example.aplikasiobengkel.data.database.OBengkelDatabase
import com.example.aplikasiobengkel.data.repository.UserRepository
import com.example.aplikasiobengkel.databinding.ActivityLoginBinding
import com.example.aplikasiobengkel.ui.auth.register.RegisterActivity
import com.example.aplikasiobengkel.ui.main.MainActivity
import com.example.obengkel_application.data.model.User



class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = obtainViewModel(this@LoginActivity)
        setupAction()
    }

    private fun setupAction() {
        binding.buttonLogin.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            val password = binding.txtPassword.text.toString()

            when{
                email.isEmpty() -> {
                    binding.layoutEmail.error = "Masukkan email"
                }
                password.isEmpty() -> {
                    binding.layoutPassword.error = "Masukkan password"
                }
                else -> {
                    viewModel.login(binding.txtEmail.text.toString())
                }
            }
        }

        viewModel.account.observe(this) {
            if (it != null) {
                if (binding.txtPassword.text.toString() == it.password) {
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    binding.txtPassword.error = "Password is incorrect"
                }
            } else {
                binding.txtEmail.error = "Username not found"
            }
        }

        binding.buttonRegister.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }

    }

    private fun obtainViewModel(activity: AppCompatActivity): LoginViewModel {
        val factory = LoginViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(LoginViewModel::class.java)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}