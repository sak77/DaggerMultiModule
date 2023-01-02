package com.saket.daggermultimodule.di

import com.saket.daggermultimodule.MainActivity
import dagger.Component

/**
 * TestBookingComponent gets Booking instance which is provided in SampleBookingModule via
 * ComponentDependencyExample component, which it has declared as a dependency here.
 * Notice how instance of the dependency component is passed as a argument to
 * create method of Factory interface. This is how the dependency is supplied to the
 * component. Next, TestBookingComponent uses Booking instance in SampleModule to
 * provide instance of User in this example.
 */
@Component(dependencies = [ComponentDependencyExample::class], modules = [SampleModule::class])
interface TestBookingComponent {

    @Component.Factory
    interface Factory {
        fun create(componentDependencyExample: ComponentDependencyExample): TestBookingComponent
    }

    /*
    In MainActivity, before calling super.onCreate().
    Do this-
            DaggerTestBookingComponent.factory()
                .create(DaggerComponentDependencyExample.create())
                .inject(this)
     */
    //Support dependencies in MainActivity.
    //fun inject(mainActivity: MainActivity)
}