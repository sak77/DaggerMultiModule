package com.saket.daggermultimodule.di

import com.saket.domain.model.Booking
import com.saket.domain.model.User
import dagger.Module
import dagger.Provides

@Module
class SampleModule {

    @Provides
    fun provideSampleUser(booking: Booking): User {
        return User(123, "Saket","Password")
    }
}