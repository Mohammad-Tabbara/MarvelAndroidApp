package com.opensource.marvelcharacters.domain

import com.opensource.marvelcharacters.framework.api.models.ApiWrapper
import com.opensource.marvelcharacters.framework.persistance.models.FavoriteCharacter
import com.opensource.marvelcharacters.framework.rxJava.LocalDbListener
import com.opensource.marvelcharacters.framework.rxJava.ObserverListener
import com.opensource.marvelcharacters.framework.rxJava.SingleListener

interface IContentManager{
    fun getMarvelCharacters(offset: Int, nameStartWith: String?, listener: SingleListener<ApiWrapper>)
    fun fetchFavoriteCharacters(listener: ObserverListener<List<FavoriteCharacter>>)
    fun inFavorites(characterId: Int, listener: ObserverListener<Boolean>)
    fun addCharacterToFavorites(favoriteCharacter: FavoriteCharacter, listener: LocalDbListener)
    fun removeFavoriteCharacter(characterId: Int, listener: LocalDbListener)
}