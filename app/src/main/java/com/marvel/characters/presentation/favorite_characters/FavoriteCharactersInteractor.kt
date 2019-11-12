package com.marvel.characters.presentation.favorite_characters

import com.marvel.characters.domain.IContentManager
import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import com.marvel.characters.framework.rxJava.ObserverListener

class FavoriteCharactersInteractor(val contentManager: IContentManager) : FavoriteCharactersContract.Interactor{

    override fun getFavoriteCharacters(listener: ObserverListener<List<FavoriteCharacter>>) {
        contentManager.fetchFavoriteCharacters(listener)
    }

}