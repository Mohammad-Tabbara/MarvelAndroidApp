package com.marvel.characters.presentation.character_details

import com.marvel.characters.domain.IContentManager
import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import com.marvel.characters.framework.rxJava.LocalDbListener
import com.marvel.characters.framework.rxJava.ObserverListener
import com.marvel.characters.framework.rxJava.SingleListener
import io.reactivex.SingleObserver

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