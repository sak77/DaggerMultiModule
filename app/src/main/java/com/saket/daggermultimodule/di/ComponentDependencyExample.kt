package com.saket.daggermultimodule.di

import com.saket.domain.model.Booking
import dagger.Component

/**
 * A detour from rest of the app. This is a sample component
 * that shows how to use component dependency to
 * pass instances from one component to another.
 */

@Component(modules = [SampleBookingModule::class])
interface ComponentDependencyExample {
    /*
    Notice: only the bindings exposed as provision
    methods (getters) are available through component dependencies.
    So we need to expose the binding for Booking,
    otherwise, TestBookingComponent can’t access it.
     */
    fun providesBooking(): Booking
}