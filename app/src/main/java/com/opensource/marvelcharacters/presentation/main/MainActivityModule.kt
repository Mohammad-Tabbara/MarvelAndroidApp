package com.opensource.marvelcharacters.presentation.main

import com.opensource.marvelcharacters.di.scopes.ViewScope
import com.opensource.marvelcharacters.domain.IContentManager
import com.opensource.marvelcharacters.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module

abstract class MainActivityModule {

    @ViewScope
    @Binds
    abstract fun bindView(mainActivity: MainActivity): MainContract.View

    @Module
    companion object{
        @ViewScope
        @Provides
        @JvmStatic
        fun providePresenter(view: MainContract.View, interator: MainContract.Interactor, logger: ILogger): MainContract.Presenter = MainPresenterImpl(view,interator,logger)

        @ViewScope
        @Provides
        @JvmStatic
        fun provideInteractor(contentManager: IContentManager): MainContract.Interactor = MainInteractor(contentManager)
    }

}