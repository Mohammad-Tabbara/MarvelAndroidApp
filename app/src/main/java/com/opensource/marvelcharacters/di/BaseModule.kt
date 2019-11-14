package com.opensource.marvelcharacters.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Binds


@Module
abstract class BaseModule {
    @Binds
    internal abstract fun provideContext(application: Application): Context
}