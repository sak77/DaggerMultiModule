package com.saket.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class RegisterViewModelFactory @Inject constructor(
    private val registerViewModel: RegisterViewModel
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return registerViewModel as T
    }
}