package com.saket.daggermultimodule.di

import com.saket.domain.model.Booking
import dagger.Module
import dagger.Provides

@Module
class SampleBookingModule {

    @Provides
    fun providesBooking(): Booking {
        return Booking("Book13", "Source",
        "DEstination", "DOJ",
        213, "FLIGHT234")
    }
}