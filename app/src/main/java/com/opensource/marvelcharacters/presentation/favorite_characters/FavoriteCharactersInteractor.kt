package com.opensource.marvelcharacters.presentation.favorite_characters

import com.opensource.marvelcharacters.domain.IContentManager
import com.opensource.marvelcharacters.framework.persistance.models.FavoriteCharacter
import com.opensource.marvelcharacters.framework.rxJava.ObserverListener

class FavoriteCharactersInteractor(val contentManager: IContentManager) : FavoriteCharactersContract.Interactor{

    override fun getFavoriteCharacters(listener: ObserverListener<List<FavoriteCharacter>>) {
        contentManager.fetchFavoriteCharacters(listener)
    }

}