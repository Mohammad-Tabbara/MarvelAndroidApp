package com.opensource.marvelcharacters.di

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.opensource.marvelcharacters.Constants
import com.opensource.marvelcharacters.domain.IAnalytics
import com.opensource.marvelcharacters.domain.IContentManager
import com.opensource.marvelcharacters.domain.ILocalDatabase
import com.opensource.marvelcharacters.domain.ILogger
import com.opensource.marvelcharacters.framework.Analytics
import com.opensource.marvelcharacters.framework.ContentManager
import com.opensource.marvelcharacters.framework.Logger
import com.opensource.marvelcharacters.framework.Navigator
import com.opensource.marvelcharacters.framework.api.ApiUtils
import com.opensource.marvelcharacters.framework.api.MarvelService
import com.opensource.marvelcharacters.framework.persistance.LocalDatabase
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
    fun provideFireBaseAnalytics(context: Context):FirebaseAnalytics = FirebaseAnalytics.getInstance(context)

    @Singleton
    @Provides
    fun provideAnalytics(firebaseAnalytics: FirebaseAnalytics):IAnalytics = Analytics(firebaseAnalytics)

    @Singleton
    @Provides
    fun provideContentManager(service: MarvelService,localDatabase: ILocalDatabase, apiUtils: ApiUtils): IContentManager = ContentManager(service,localDatabase,apiUtils)

    @Singleton
    @Provides
    fun provideLogger(): ILogger = Logger()
}