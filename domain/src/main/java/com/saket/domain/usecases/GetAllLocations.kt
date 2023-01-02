package com.saket.domain.usecases

import com.saket.domain.model.Location
import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.*

class GetAllLocations(
    private val bookingRepository: IBookingRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : UseCase<Location?, Deferred<List<Location>>>(
    bookingRepository, coroutineDispatcher
) {
    override fun execute(coroutineScope: CoroutineScope, args: Location?) =
        coroutineScope.async(coroutineDispatcher) {
            bookingRepository.getAllLocations()
        }
}
