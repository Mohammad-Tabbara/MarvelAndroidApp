package com.opensource.marvelcharacters.presentation.character_details

import com.opensource.marvelcharacters.domain.IContentManager
import com.opensource.marvelcharacters.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class CharacterDetailsModule {

    @Binds
    abstract fun bindView(mainActivity: CharacterDetailsActivity): CharacterDetailsContract.View

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun providePresenter(view: CharacterDetailsContract.View, interactor: CharacterDetailsContract.Interactor, logger: ILogger): CharacterDetailsContract.Presenter = CharacterDetailsPresenterImpl(view,interactor,logger)

        @Provides
        @JvmStatic
        fun provideInteractor(contentManager: IContentManager): CharacterDetailsContract.Interactor = CharacterDetailsInteractor(contentManager)

    }

}