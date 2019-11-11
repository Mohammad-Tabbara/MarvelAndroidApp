package com.marvel.characters.domain

interface ILocalDatabase {
    fun addCharacterToFavorites()
    fun removeCharacterFromFavorites()
    fun getFavoriteCharacters()
}