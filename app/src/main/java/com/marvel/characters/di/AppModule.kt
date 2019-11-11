package com.marvel.characters.di

import android.content.Context
import com.marvel.characters.Constants
import com.marvel.characters.domain.IContentManager
import com.marvel.characters.domain.ILocalDatabase
import com.marvel.characters.domain.ILogger
import com.marvel.characters.framework.ContentManager
import com.marvel.characters.framework.Logger
import com.marvel.characters.framework.Navigator
import com.marvel.characters.framework.api.ApiUtils
import com.marvel.characters.framework.api.MarvelService
import com.marvel.characters.framework.persistance.LocalDatabase
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
    fun provideLocalDatabase(context: Context):ILocalDatabase = LocalDatabase.newInstance(context)

    @Singleton
    @Provides
    fun provideContentManager(service: MarvelService,localDatabase: ILocalDatabase, apiUtils: ApiUtils): IContentManager = ContentManager(service,localDatabase,apiUtils)

    @Singleton
    @Provides
    fun provideLogger(): ILogger = Logger()
}