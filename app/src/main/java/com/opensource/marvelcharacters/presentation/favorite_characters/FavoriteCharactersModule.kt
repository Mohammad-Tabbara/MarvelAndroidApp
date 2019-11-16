package com.opensource.marvelcharacters.presentation.favorite_characters

import com.opensource.marvelcharacters.domain.IContentManager
import com.opensource.marvelcharacters.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class FavoriteCharactersModule {

    @Binds
    abstract fun bindView(activity: FavoriteCharactersActivity): FavoriteCharactersContract.View

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun providePresenter(view: FavoriteCharactersContract.View,interactor: FavoriteCharactersContract.Interactor,logger: ILogger): FavoriteCharactersContract.Presenter = FavoriteCharactersPresenterImpl(view,interactor,logger)

        @Provides
        @JvmStatic
        fun provideInteractor(contentManager: IContentManager): FavoriteCharactersContract.Interactor = FavoriteCharactersInteractor(contentManager)

    }
}