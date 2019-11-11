package com.marvel.characters.presentation.favorite_characters

import com.marvel.characters.domain.ILogger

class FavoriteCharactersPresenterImpl(val view: FavoriteCharactersContract.View, val interactor: FavoriteCharactersContract.Interactor, val logger: ILogger): FavoriteCharactersContract.Presenter {
    override fun onCreate() {

    }

}
