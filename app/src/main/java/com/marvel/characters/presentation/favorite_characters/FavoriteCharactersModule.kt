package com.marvel.characters.presentation.favorite_characters

import com.marvel.characters.domain.IContentManager
import com.marvel.characters.domain.ILogger
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
        fun providePresenter(view: FavoriteCharactersContract.View,interactor: FavoriteCharactersInteractor,logger: ILogger) = FavoriteCharactersPresenterImpl(view,interactor,logger)

        @Provides
        @JvmStatic
        fun provideInteractor(contentManager: IContentManager) = FavoriteCharactersInteractor(contentManager)

    }
}