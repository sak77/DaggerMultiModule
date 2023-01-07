package com.saket.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.saket.domain.model.User
import com.saket.login.databinding.FragmentLoginBinding
import com.saket.login.di.LoginComponentProvider
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var loginViewModelFactory: LoginViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val loginComponentProvider = activity?.applicationContext as LoginComponentProvider
        val loginComponent = loginComponentProvider.provideLoginComponent()
        loginComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.btnLogin.setOnClickListener {
            val userName = binding.userName.text.toString()
            val password = binding.password.text.toString()
            val loginViewModel: LoginViewModel by viewModels {
                loginViewModelFactory
            }
            val id = (1..10).random()
            loginViewModel.authenticateUser(User(id, userName, password))
        }
        return binding.root
    }
}