package com.opensource.marvelcharacters.di

import android.app.Application
import com.opensource.marvelcharacters.MarvellApplication
import dagger.Component
import dagger.BindsInstance
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityBuilder::class,AndroidSupportInjectionModule::class,AppModule::class])
interface AppComponent: AndroidInjector<MarvellApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }

}