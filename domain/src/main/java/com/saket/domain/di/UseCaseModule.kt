package com.saket.domain.di

import dagger.Provides
import dagger.Module
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class UseCaseModule {

    companion object {
        @Provides
        fun provideDefaultCoroutineDispatcher(): CoroutineDispatcher {
            return Dispatchers.Default
        }
    }
}
