package com.marvel.characters.presentation.favorite_characters

import com.marvel.characters.domain.IContentManager
import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import io.reactivex.CompletableObserver
import io.reactivex.Observer
import io.reactivex.Single

class FavoriteCharactersInteractor(val contentManager: IContentManager) : FavoriteCharactersContract.Interactor{

    override fun getFavoriteCharacters(listener: Observer<List<FavoriteCharacter>>) {
        contentManager.fetchFavoriteCharacters(listener)
    }

}