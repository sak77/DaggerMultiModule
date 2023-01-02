package com.saket.booking.di

import com.saket.booking.BookingFragment
import com.saket.domain.di.BookingUseCaseModule
import dagger.Subcomponent


@Subcomponent(modules = [BookingUseCaseModule::class])
interface BookingComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): BookingComponent
    }

    //Support field injection for Booking fragment
    fun inject(fragment: BookingFragment)
}