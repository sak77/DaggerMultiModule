package com.saket.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saket.domain.model.User
import com.saket.domain.usecases.AuthenticateUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

/*
ViewModel should be created using ViewModelProvider
at some point. It might be hidden inside a
delegate “by viewModels { factory }” or be called directly.
However, without it, ViewModel won’t persist through
configuration changes, and its onCleared method won’t be
called when it’s no longer needed.
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