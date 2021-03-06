package com.opensource.marvelcharacters.presentation.favorite_characters

import com.opensource.marvelcharacters.di.scopes.ViewScope
import com.opensource.marvelcharacters.domain.IContentManager
import com.opensource.marvelcharacters.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class FavoriteCharactersModule {

    @ViewScope
    @Binds
    abstract fun bindView(activity: FavoriteCharactersActivity): FavoriteCharactersContract.View

    @Module
    companion object{
        @ViewScope
        @Provides
        @JvmStatic
        fun providePresenter(view: FavoriteCharactersContract.View,interactor: FavoriteCharactersContract.Interactor,logger: ILogger): FavoriteCharactersContract.Presenter = FavoriteCharactersPresenterImpl(view,interactor,logger)

        @ViewScope
        @Provides
        @JvmStatic
        fun provideInteractor(contentManager: IContentManager): FavoriteCharactersContract.Interactor = FavoriteCharactersInteractor(contentManager)

    }
}