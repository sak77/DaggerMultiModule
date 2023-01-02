package com.saket.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saket.domain.model.User
import com.saket.domain.usecases.AddUser
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
private val addUser: AddUser
) : ViewModel() {

    fun registerUser(user: User) {
        val registerJob = addUser.execute(viewModelScope, user)
        registerJob.invokeOnCompletion {
            it?.let {
                println("User add error...$it")
            }
            println("User added...")
        }
    }
}