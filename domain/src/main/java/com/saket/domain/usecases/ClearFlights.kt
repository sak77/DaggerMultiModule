package com.saket.domain.usecases

import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ClearFlights(private val bookingRepository: IBookingRepository,
private val coroutineDispatcher: CoroutineDispatcher) : UseCase<Unit?, Unit>(bookingRepository, coroutineDispatcher) {
    override fun execute(coroutineScope: CoroutineScope, args: Unit?) {
        coroutineScope.launch(coroutineDispatcher) {
            bookingRepository.removeAllFlights()
        }
    }
}