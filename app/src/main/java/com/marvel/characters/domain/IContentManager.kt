package com.marvel.characters.domain

import com.marvel.characters.framework.api.models.ApiWrapper
import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import io.reactivex.CompletableObserver
import io.reactivex.Observer
import io.reactivex.SingleObserver

interface IContentManager{
    fun getMarvelCharacters(offset: Int, nameStartWith: String?, listener: SingleObserver<ApiWrapper>)
    fun fetchFavoriteCharacters(listener: Observer<List<FavoriteCharacter>>)
    fun addCharacterToFavorites(favoriteCharacter: FavoriteCharacter, listener: CompletableObserver)
}