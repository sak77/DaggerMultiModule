package com.saket.domain.usecases

import com.saket.domain.model.User
import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetAllUsers(
    private val bookingRepository: IBookingRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) :
    FlowUseCase<User, List<User>>(
        bookingRepository, coroutineDispatcher
    ) {
    override fun executeFlow(coroutineScope: CoroutineScope, args: User): Flow<List<User>> =
        bookingRepository.getAllUsers()
            .flowOn(coroutineDispatcher)
}