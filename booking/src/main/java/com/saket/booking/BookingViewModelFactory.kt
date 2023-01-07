package com.saket.booking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class BookingViewModelFactory @Inject constructor(
    private val bookingViewModel: BookingViewModel
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return bookingViewModel as T
    }
}