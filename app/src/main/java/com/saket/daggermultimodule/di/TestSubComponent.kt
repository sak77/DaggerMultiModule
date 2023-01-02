package com.saket.daggermultimodule.di

import com.saket.daggermultimodule.MainActivity
import com.saket.data.db.BookingDB
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [SampleModule::class])
interface TestSubComponent {

    /*
    @Subcomponent.Builder
    interface Builder {
        fun build(): TestSubComponent
    }
     */
    @Subcomponent.Factory
    interface Factory {
        fun create(): TestSubComponent
    }

    fun inject(mainActivity: MainActivity)
}