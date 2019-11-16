package com.opensource.marvelcharacters.presentation.character_details

import com.opensource.marvelcharacters.domain.IContentManager
import com.opensource.marvelcharacters.framework.persistance.models.FavoriteCharacter
import com.opensource.marvelcharacters.framework.rxJava.LocalDbListener
import com.opensource.marvelcharacters.framework.rxJava.ObserverListener

class CharacterDetailsInteractor(val contentManager: IContentManager): CharacterDetailsContract.Interactor{

    override fun inFavorites(characterId: Int, listener: ObserverListener<Boolean>) {
        contentManager.inFavorites(characterId,listener)
    }

    override fun addToFavorites(favoriteCharacter: FavoriteCharacter, listener: LocalDbListener) {
        contentManager.addCharacterToFavorites(favoriteCharacter,listener)
    }

    override fun removeFromFavorites(characterId: Int, listener: LocalDbListener) {
        contentManager.removeFavoriteCharacter(characterId,listener)
    }
}