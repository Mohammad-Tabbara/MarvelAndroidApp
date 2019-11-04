package com.marvel.charecters.presentation.main

import com.marvel.charecters.domain.IContentManager
import com.marvel.charecters.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun bindView(mainActivity: MainActivity): MainContract.View

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun bindPresenter(view: MainContract.View,interator: MainContract.Interactor, logger: ILogger): MainContract.Presenter = MainPresenterImpl(view,interator,logger)

        @Provides
        @JvmStatic
        fun bindInteractor(contentManager: IContentManager): MainContract.Interactor = MainInteractor(contentManager)
    }

}