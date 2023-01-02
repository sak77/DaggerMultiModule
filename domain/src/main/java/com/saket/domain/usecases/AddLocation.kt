package com.saket.domain.usecases

import com.saket.domain.model.Location
import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AddLocation constructor(
    private val bookingRepository: IBookingRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : UseCase<Location, Job>(bookingRepository, coroutineDispatcher) {
    override fun execute(coroutineScope: CoroutineScope, args: Location) =
        coroutineScope.launch(coroutineDispatcher) {
            bookingRepository.addLocation(args)
        }
}