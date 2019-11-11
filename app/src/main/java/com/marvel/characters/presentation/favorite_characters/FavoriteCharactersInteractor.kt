package com.marvel.characters.presentation.favorite_characters

import android.database.Observable
import com.marvel.characters.domain.IContentManager
import com.marvel.characters.framework.api.Character

class FavoriteCharactersInteractor(val contentManager: IContentManager) : FavoriteCharactersContract.Interactor{
    override fun getFavoriteCharacters(listener: Observable<List<Character>>) {

    }

}