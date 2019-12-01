package com.opensource.marvelcharacters.presentation.character_details

import com.opensource.marvelcharacters.di.scopes.ViewScope
import com.opensource.marvelcharacters.domain.IContentManager
import com.opensource.marvelcharacters.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class CharacterDetailsModule {

    @ViewScope
    @Binds
    abstract fun bindView(mainActivity: CharacterDetailsActivity): CharacterDetailsContract.View

    @Module
    companion object{
        @ViewScope
        @Provides
        @JvmStatic
        fun providePresenter(view: CharacterDetailsContract.View, interactor: CharacterDetailsContract.Interactor, logger: ILogger): CharacterDetailsContract.Presenter = CharacterDetailsPresenterImpl(view,interactor,logger)

        @ViewScope
        @Provides
        @JvmStatic
        fun provideInteractor(contentManager: IContentManager): CharacterDetailsContract.Interactor = CharacterDetailsInteractor(contentManager)

    }

}