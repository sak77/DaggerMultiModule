package com.saket.domain.usecases

import com.saket.domain.model.Flight
import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

class GetAllFlights(private val bookingRepository: IBookingRepository,
private val coroutineDispatcher: CoroutineDispatcher) : UseCase<Flight?, Deferred<List<Flight>>>(
    bookingRepository, coroutineDispatcher
) {
    override fun execute(coroutineScope: CoroutineScope, args: Flight?): Deferred<List<Flight>> =
        coroutineScope.async(coroutineDispatcher) {
        bookingRepository.getAllFlights()
    }
}