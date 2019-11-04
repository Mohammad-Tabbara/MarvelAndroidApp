package com.marvel.charecters.di

import android.app.Application
import android.content.Context
import com.marvel.charecters.domain.ILogger
import com.marvel.charecters.framework.Logger
import com.marvel.charecters.framework.Navigator
import dagger.Module
import dagger.Binds
import dagger.Provides
import javax.inject.Singleton


@Module
abstract class BaseModule {
    @Binds
    internal abstract fun provideContext(application: Application): Context
}