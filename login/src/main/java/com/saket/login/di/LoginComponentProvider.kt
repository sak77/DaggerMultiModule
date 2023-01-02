package com.saket.login.di


/**
 * LoginComponent is a subcomponent of ApplicationComponent
 * So its instance is created from the ApplicationComponent class in
 * the app module.
 *
 * But in this app, login module does not have dependency on app module,
 * instead it is the other way around.
 *
 * So, to create instance of LoginComponent, one has to create an
 * interface like this and implement it in the app module's
 * Application class. The application class will create the ApplicationComponent
 * instance and also override the function which provides LoginComponent instance.
 */
interface LoginComponentProvider {

    fun provideLoginComponent(): LoginComponent
}