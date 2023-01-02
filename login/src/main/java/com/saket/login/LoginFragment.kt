package com.saket.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.saket.domain.model.User
import com.saket.login.databinding.FragmentLoginBinding
import com.saket.login.di.LoginComponentProvider
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var loginViewModel: LoginViewModel

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
        val binding = FragmentLoginBinding.inflate(inflater,container, false)
        binding.btnLogin.setOnClickListener {
            val userName = binding.userName.text.toString()
            val password = binding.password.text.toString()
            Toast.makeText(context,"UserName: $userName, password: $password", Toast.LENGTH_LONG).show()
            val id = (1..10).random()
            loginViewModel.authenticateUser(User(id, userName, password))
        }
        return binding.root
    }
}