package com.opensource.marvelcharacters

import com.opensource.marvelcharacters.di.DaggerAppComponent
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber


class MarvellApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder().application(this).build()
}