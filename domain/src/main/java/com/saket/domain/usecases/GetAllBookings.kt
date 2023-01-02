package com.saket.domain.usecases

import com.saket.domain.model.Booking
import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetAllBookings(
    private val bookingRepository: IBookingRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : FlowUseCase<Booking?, List<Booking>>(
    bookingRepository, coroutineDispatcher
) {
    override fun executeFlow(coroutineScope: CoroutineScope, args: Booking?): Flow<List<Booking>> =
        bookingRepository.getAllBookings().flowOn(coroutineDispatcher)
}