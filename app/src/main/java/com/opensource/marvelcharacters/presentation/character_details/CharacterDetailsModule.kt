package com.opensource.marvelcharacters.presentation.character_details

import com.opensource.marvelcharacters.di.scopes.ViewScope
import com.opensource.marvelcharacters.domain.IContentManager
import com.opensource.marvelcharacters.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [CharacterDetailsProviders::class])
abstract class CharacterDetailsModule {

    @ViewScope
    @Binds
    abstract fun bindView(mainActivity: CharacterDetailsActivity): CharacterDetailsContract.View

}

@Module
object CharacterDetailsProviders{
    @ViewScope
    @Provides
    fun providePresenter(view: CharacterDetailsContract.View, interactor: CharacterDetailsContract.Interactor, logger: ILogger): CharacterDetailsContract.Presenter = CharacterDetailsPresenterImpl(view,interactor,logger)

    @ViewScope
    @Provides
    fun provideInteractor(contentManager: IContentManager): CharacterDetailsContract.Interactor = CharacterDetailsInteractor(contentManager)

}