package com.saket.domain.usecases

import com.saket.domain.model.Booking
import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AddBooking(
    private val bookingRepository: IBookingRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : UseCase<Booking, Job>(bookingRepository, coroutineDispatcher) {
    override fun execute(coroutineScope: CoroutineScope, args: Booking) =
        coroutineScope.launch(coroutineDispatcher) {
            bookingRepository.addBooking(args)
        }
}