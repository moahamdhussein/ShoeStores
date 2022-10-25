package com.example.shoestores.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestores.R
import com.example.shoestores.databinding.FragmentLoginBinding
import com.example.shoestores.viewModel.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        loginViewModel = ViewModelProvider(owner = this).get(LoginViewModel::class.java)

        binding.btnLogin.setOnClickListener {
            if (showCheckError()) {
                val action = LoginFragmentDirections.loginToWelcome()
                findNavController().navigate(action)
            }
        }
        binding.btnSignIn.setOnClickListener {
            if (showCheckError()) {
                val action = LoginFragmentDirections.loginToWelcome()
                findNavController().navigate(action)
            }
        }

        return binding.root
    }

    // function to validate data in login
    private fun showCheckError(): Boolean {
        clearError()
        var check = true

        if (!loginViewModel.checkValidationUserName(getUserName())) {
            binding.tilUserName.error = "User name must not be empty"
            binding.tilUserName.isErrorEnabled = true
            check = false
        }

        if (!loginViewModel.checkValidationEmail(getEmail())) {
            binding.tilEmail.error = "enter valid email"
            binding.tilEmail.isErrorEnabled = true
            check = false
        }

        if (!loginViewModel.checkValidationPassword(getPassword())) {
            binding.tilPassword.error = "password must be more than 6 letters or numbers"
            binding.tilPassword.isErrorEnabled = true
            check = false
        }
        return check
    }

    // to clear error warning
    private fun clearError() {

        binding.tilUserName.error = null
        binding.tilUserName.isErrorEnabled = false

        binding.tilEmail.error = null
        binding.tilEmail.isErrorEnabled = false

        binding.tilPassword.error = null
        binding.tilPassword.isErrorEnabled = false


    }

    private fun getUserName(): String {
        return binding.etUserName.text.toString()
    }

    private fun getPassword(): String {
        return binding.etPassword.text.toString()
    }

    private fun getEmail(): String {
        return binding.etEmail.text.toString()
    }

}