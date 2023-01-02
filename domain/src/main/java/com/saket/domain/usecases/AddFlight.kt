package com.saket.domain.usecases

import com.saket.domain.model.Flight
import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AddFlight(
    private val bookingRepository: IBookingRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : UseCase<Flight, Job>(
    bookingRepository,
    coroutineDispatcher
) {
    override fun execute(coroutineScope: CoroutineScope, args: Flight) =
        coroutineScope.launch(coroutineDispatcher) {
            bookingRepository.addFlight(args)
        }
}