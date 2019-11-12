package com.marvel.characters.presentation.character_details

import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import com.marvel.characters.framework.rxJava.LocalDbListener
import com.marvel.characters.framework.rxJava.ObserverListener
import com.marvel.characters.framework.rxJava.SingleListener
import com.marvel.characters.presentation._common.models.Character

interface CharacterDetailsContract {
    interface View{
        fun initLayout(character: Character?, hasWikiPage: Boolean)
        fun openInWebView(url: String?)
        fun initFavorites(favorite: Boolean)
    }
    interface Presenter{
        var isFavorite: Boolean
        fun onCreate(character: Character?)
        fun openWikiClicked()
        fun toggleFavorite()
    }

    interface Interactor{
        fun inFavorites(characterId: Int, listener: ObserverListener<Boolean>)
        fun addToFavorites(favoriteCharacter: FavoriteCharacter, listener: LocalDbListener)
        fun removeFromFavorites(characterId: Int, listener: LocalDbListener)
    }
}