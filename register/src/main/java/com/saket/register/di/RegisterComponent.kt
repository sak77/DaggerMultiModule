package com.saket.register.di

import com.saket.domain.di.RegisterUseCaseModule
import com.saket.domain.di.UseCaseModule
import com.saket.domain.usecases.UseCase
import com.saket.register.RegisterFragment
import dagger.Component
import dagger.Subcomponent

//Unscoped Component may not reference scoped bindings. For eg -
//provider function with annotation @Singleton
@Subcomponent(modules = [RegisterUseCaseModule::class])
interface RegisterComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegisterComponent
    }

    //Support Field Injection for RegisterFragment
    fun inject(fragment: RegisterFragment)
}
