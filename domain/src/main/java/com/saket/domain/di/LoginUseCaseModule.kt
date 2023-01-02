package com.saket.domain.di

import com.saket.domain.repository.IBookingRepository
import com.saket.domain.usecases.AuthenticateUseCase
import com.saket.domain.usecases.GetAllUsers
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

import dagger.Module

/**
 * LoginUseCaseModule is composed of dependencies from UseCaseModule
 */
@Module(includes = [UseCaseModule::class])
class LoginUseCaseModule {

    /*
    It is supposed to be a good practice to have
    static provider methods. Theoretically, it improves
    performance and since it does not require module instance.
    But still not entirely sure why...
     */
    companion object {
        @Provides
        fun providesAuthenticateUserCase(
            bookingRepository: IBookingRepository,
            coroutineDispatcher: CoroutineDispatcher
        ): AuthenticateUseCase {
            return AuthenticateUseCase(bookingRepository, coroutineDispatcher)
        }

        @Provides
        fun providesGetAllUsers(
            bookingRepository: IBookingRepository,
            coroutineDispatcher: CoroutineDispatcher
        ): GetAllUsers {
            return GetAllUsers(bookingRepository, coroutineDispatcher)
        }
    }
}