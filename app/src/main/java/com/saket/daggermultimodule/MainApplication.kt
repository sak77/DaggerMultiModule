package com.saket.daggermultimodule

import android.app.Application
import com.saket.booking.di.BookingComponent
import com.saket.booking.di.BookingComponentProvider
import com.saket.daggermultimodule.di.ApplicationComponent
import com.saket.daggermultimodule.di.DaggerApplicationComponent
import com.saket.data.di.RepositoryModule
import com.saket.login.di.LoginComponent
import com.saket.login.di.LoginComponentProvider
import com.saket.register.di.RegisterComponent
import com.saket.register.di.RegisterComponentProvider

class MainApplication : Application(),
    LoginComponentProvider,
    RegisterComponentProvider,
    BookingComponentProvider {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .buildsContext(applicationContext)
            .build()
    }

    override fun provideLoginComponent(): LoginComponent {
        return applicationComponent.loginComponent().create()
    }

    override fun provideRegisterComponent(): RegisterComponent {
        return applicationComponent.registerComponent().create()
    }

    override fun provideBookingComponent(): BookingComponent {
        return applicationComponent.bookingComponent().create()
    }
}