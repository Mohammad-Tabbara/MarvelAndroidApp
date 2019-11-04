package com.marvel.charecters.di

import com.marvel.charecters.Constants
import com.marvel.charecters.domain.IContentManager
import com.marvel.charecters.domain.ILogger
import com.marvel.charecters.framework.ContentManager
import com.marvel.charecters.framework.Logger
import com.marvel.charecters.framework.Navigator
import com.marvel.charecters.framework.api.ApiUtils
import com.marvel.charecters.framework.api.MarvelService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [BaseModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideMarvelApi(): MarvelService {
        return Retrofit.Builder()
            .baseUrl(Constants.MARVEL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(MarvelService::class.java)
    }

    @Singleton
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @Singleton
    @Provides
    fun provideApiUtils():ApiUtils = ApiUtils()

    @Singleton
    @Provides
    fun provideContentManager(service: MarvelService, apiUtils: ApiUtils): IContentManager = ContentManager(service,apiUtils)

    @Singleton
    @Provides
    fun provideLogger(): ILogger = Logger()
}