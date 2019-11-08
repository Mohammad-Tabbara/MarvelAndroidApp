package com.marvel.characters

import com.marvel.characters.di.DaggerAppComponent
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber


class MarvellApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        Picasso.get().isLoggingEnabled = true
        Timber.plant(Timber.DebugTree())
    }
}