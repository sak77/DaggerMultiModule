package com.saket.login.di

import com.saket.domain.di.LoginUseCaseModule
import com.saket.login.LoginFragment
import dagger.Subcomponent

@Subcomponent(modules = [LoginUseCaseModule::class])
interface LoginComponent {

    /*
    In Dagger2.12 we got two new annotations @Component.Builder
    and @BindsInstances for doing the same thing we previously
    were doing by passing arguments to the constructor.
    We don’t have provide method in our module anymore.
     */
    /*
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun appContext(context: Context): Builder
        //the usecaseModule is optional if the constructor does not have any parameters
        //fun usecaseModule(usecaseModule: UseCaseModule): Builder
        fun build(): LoginComponent
    }
     */

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    //Support field injection for these fragments
    fun inject(loginFragment: LoginFragment)
}
