package com.saket.domain.usecases

import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

/**
 * Having a UseCase abstract class helps to make sure all
 * use cases follow the same template.
 */
abstract class UseCase<T, R>(
    bookingRepository: IBookingRepository,
    coroutineDispatcher: CoroutineDispatcher
) {
    abstract fun execute(coroutineScope: CoroutineScope, args: T): R
}