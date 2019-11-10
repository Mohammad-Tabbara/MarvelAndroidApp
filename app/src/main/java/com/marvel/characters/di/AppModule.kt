package com.marvel.characters.di

import com.marvel.characters.Constants
import com.marvel.characters.domain.IContentManager
import com.marvel.characters.domain.ILogger
import com.marvel.characters.framework.ContentManager
import com.marvel.characters.framework.Logger
import com.marvel.characters.framework.Navigator
import com.marvel.characters.framework.api.ApiUtils
import com.marvel.characters.framework.api.MarvelService
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