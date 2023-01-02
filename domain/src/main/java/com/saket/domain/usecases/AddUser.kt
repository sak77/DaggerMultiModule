package com.saket.domain.usecases

import com.saket.domain.model.User
import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AddUser(
    private  val bookingRepository: IBookingRepository,
    private  val coroutineDispatcher: CoroutineDispatcher
) : UseCase<User, Job>(bookingRepository, coroutineDispatcher) {
    override fun execute(coroutineScope: CoroutineScope, args: User) =
        coroutineScope.launch(coroutineDispatcher) {
            println("Saket AddUSer bookingRepo.addUser")
            bookingRepository.addUser(args)
        }
}