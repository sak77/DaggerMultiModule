package com.saket.domain.usecases

import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<T, R>(
    bookingRepository: IBookingRepository,
    coroutineDispatcher: CoroutineDispatcher
) {

    abstract fun executeFlow(coroutineScope: CoroutineScope, args: T): Flow<R>
}