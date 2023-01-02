package com.saket.domain.usecases

import com.saket.domain.model.User
import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.*

class AuthenticateUseCase(
    private val bookingRepository: IBookingRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : UseCase<User, Deferred<User?>>(
    bookingRepository, coroutineDispatcher
) {
    override fun execute(coroutineScope: CoroutineScope, args: User) =
        coroutineScope.async(coroutineDispatcher) {
            println("Saket coroutineScope.async")
            bookingRepository.authenticateUser(args.name, args.password)
        }
}