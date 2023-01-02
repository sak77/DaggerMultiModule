package com.saket.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saket.domain.model.User
import com.saket.domain.usecases.AuthenticateUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

/*
Using DI allows to skip ViewModelFactory class.
 */
class LoginViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase
) : ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    fun authenticateUser(user: User): Boolean {
        println("Saket LoginViewModel authenticateUser")
        var resultUser: User?
        val result = authenticateUseCase.execute(viewModelScope, user)
        result.invokeOnCompletion { error ->
            println("Saket result.invokeOnCompletion")
            if (error == null) {
                resultUser = result.getCompleted()
                resultUser?.let {
                    CurrentUser.setCurrentUser(it.userId, it.password)
                    println("Saket user authenticated ${CurrentUser.getInstance()}")
                }
                println("Saket user not authenticated")
            } else {
                println("Saket error: $error")
            }
        }
        return false
    }

}