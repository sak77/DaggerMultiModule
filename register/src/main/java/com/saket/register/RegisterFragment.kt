package com.saket.register

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.saket.domain.model.User
import com.saket.register.databinding.FragmentRegisterBinding
import com.saket.register.di.RegisterComponentProvider
import javax.inject.Inject

class RegisterFragment : Fragment() {

    //Note: Dagger cannot inject private variables
    @Inject
    lateinit var registerViewModel: RegisterViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*
        DaggerRegisterComponent.builder()
            .registerModule(RegisterModule(context))
            .build()
            .inject(this)
         */
        val registerComponentProvider = activity?.applicationContext as RegisterComponentProvider
        val registerComponent = registerComponentProvider.provideRegisterComponent()
        registerComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.btnRegister.setOnClickListener {
            val userName = binding.userName.text.toString()
            val password = binding.password.text.toString()
            val id = (1..10).random()
            registerViewModel.registerUser(User(id, userName, password))
        }
        return binding.root
    }
}