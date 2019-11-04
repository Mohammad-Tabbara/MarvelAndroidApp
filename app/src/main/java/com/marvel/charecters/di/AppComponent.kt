package com.marvel.charecters.di

import android.app.Application
import com.marvel.charecters.MarvellApplication
import dagger.Component
import dagger.BindsInstance
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityBuilder::class,AndroidInjectionModule::class,AppModule::class])
interface AppComponent: AndroidInjector<MarvellApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }

}