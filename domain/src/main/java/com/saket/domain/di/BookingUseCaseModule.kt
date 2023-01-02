package com.saket.domain.di

import com.saket.domain.repository.IBookingRepository
import com.saket.domain.usecases.*
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Module can also be directly included into other modules.
 * In this case BookingUseCaseModule can use the instances
 * provided by UseCaseModule (CoroutineDispatcher).
 */
@Module(includes = [UseCaseModule::class])
class BookingUseCaseModule {

    /*
    TODO: Possible memory leak -
    BookingRepository has instance of BookingDB which holds instance of
    context. So maybe these provider functions should not be static??
     */
    companion object {
        @Provides
        fun providesAddBookingUseCase(bookingRepository: IBookingRepository, coroutineDispatcher: CoroutineDispatcher): AddBooking {
            return AddBooking(bookingRepository, coroutineDispatcher)
        }

        @Provides
        fun providesAddFlightUseCase(bookingRepository: IBookingRepository, coroutineDispatcher: CoroutineDispatcher): AddFlight {
            return AddFlight(bookingRepository, coroutineDispatcher)
        }

        @Provides
        fun providesAddLocationUseCase(bookingRepository: IBookingRepository, coroutineDispatcher: CoroutineDispatcher): AddLocation {
            return AddLocation(bookingRepository, coroutineDispatcher)
        }

        @Provides
        fun providesGetAllBookingsCase(bookingRepository: IBookingRepository, coroutineDispatcher: CoroutineDispatcher): GetAllBookings {
            return GetAllBookings(bookingRepository, coroutineDispatcher)
        }

        @Provides
        fun providesGetAllFlightsCase(bookingRepository: IBookingRepository, coroutineDispatcher: CoroutineDispatcher): GetAllFlights {
            return GetAllFlights(bookingRepository, coroutineDispatcher)
        }

        @Provides
        fun providesGetAllLocationsCase(bookingRepository: IBookingRepository, coroutineDispatcher: CoroutineDispatcher): GetAllLocations {
            return GetAllLocations(bookingRepository, coroutineDispatcher)
        }

        @Provides
        fun providesClearLocations(bookingRepository: IBookingRepository, coroutineDispatcher: CoroutineDispatcher): ClearLocations {
            return ClearLocations(bookingRepository, coroutineDispatcher)
        }

        @Provides
        fun providesClearFlights(bookingRepository: IBookingRepository, coroutineDispatcher: CoroutineDispatcher): ClearFlights {
            return ClearFlights(bookingRepository, coroutineDispatcher)
        }
    }
}