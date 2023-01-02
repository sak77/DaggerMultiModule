package com.saket.daggermultimodule.di

import android.content.Context
import com.saket.booking.di.BookingComponent
import com.saket.booking.di.BookingComponentModule
import com.saket.daggermultimodule.MainActivity
import com.saket.data.di.RepositoryModule
import com.saket.login.di.LoginComponent
import com.saket.login.di.SubcomponentLoginModule
import com.saket.register.di.RegisterComponent
import com.saket.register.di.SubcomponentRegisterModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module

/**
 * The idea here is that since DB instance has to be
 * for the whole application lifetime scope. So it is
 * provided via the ApplicationComponent class.
 *
 * It is included here as a module of ApplicationComponent class.
 * ApplicationComponent class will have Subcomponents in
 * different project modules which will extend it and will
 * also be able to access the DB instance provided by it.
 */
//@Singleton - is it required? since only being instantiated in application class..
@Component(
    modules = [RepositoryModule::class,
        SubcomponentLoginModule::class,
        SubcomponentRegisterModule::class,
        BookingComponentModule::class
    ]
)
interface ApplicationComponent {

    /*
    Since RepositoryModule requires instance of context class,
    i have created a Factory interface here which binds instance of
    context class to the Dagger graph of this component (@BindsInstance).
     */
    /*
    If any of the modules installed by this component has a constructor arguments,
    then i have to add their instance as arguments to the create function also.
     */
    /*
    @Component.Builder is similar to @Component.Factory, except that there instead
    of having each dependency as a argument to create function, there would be a
    separate builder function with that dependency as an argument.
    @Component.Builder was introduced in Dagger 2.12 whereas @Component.Factory was
    Dagger 2.22.

    Note: A Component cannot have both Builder and Factory interfaces. Only any one.
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun buildsContext(context: Context): Builder
        fun build(): ApplicationComponent
    }

/*
**** SAME THING DONE WITH FACTORY INSTANCE ****
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

In this case ApplicationComponent can be instantiated as follows -
DaggerApplicationComponent.factory().create(applicationContext)
 */

    //Expose Factory instances of respective SubComponents
    fun loginComponent(): LoginComponent.Factory
    fun registerComponent(): RegisterComponent.Factory
    fun bookingComponent(): BookingComponent.Factory

    //Supports field injection in MainActivity
    fun inject(mainActivity: MainActivity)
}
