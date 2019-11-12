package com.marvel.characters.domain

import com.marvel.characters.framework.api.models.ApiWrapper
import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import com.marvel.characters.framework.rxJava.LocalDbListener
import com.marvel.characters.framework.rxJava.ObserverListener
import com.marvel.characters.framework.rxJava.SingleListener

interface IContentManager{
    fun getMarvelCharacters(offset: Int, nameStartWith: String?, listener: SingleListener<ApiWrapper>)
    fun fetchFavoriteCharacters(listener: ObserverListener<List<FavoriteCharacter>>)
    fun inFavorites(characterId: Int, listener: ObserverListener<Boolean>)
    fun addCharacterToFavorites(favoriteCharacter: FavoriteCharacter, listener: LocalDbListener)
    fun removeFavoriteCharacter(characterId: Int, listener: LocalDbListener)
}