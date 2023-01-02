package com.saket.domain.di

import com.saket.domain.repository.IBookingRepository
import com.saket.domain.usecases.AddUser
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module(includes = [UseCaseModule::class])
class RegisterUseCaseModule {

    companion object {
        @Provides
        fun providesAddUserCase(
            bookingRepository: IBookingRepository,
            coroutineDispatcher: CoroutineDispatcher
        ): AddUser {
            return AddUser(bookingRepository, coroutineDispatcher)
        }
    }
}