package com.saket.login.di

import dagger.Module

/**
 * Each subcomponent needs to be included in a Module
 * which can then be included in the parent component.
 */
@Module(subcomponents = [LoginComponent::class])
class SubcomponentLoginModule {
}