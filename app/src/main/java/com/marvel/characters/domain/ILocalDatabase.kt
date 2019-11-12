package com.marvel.characters.domain

import com.marvel.characters.framework.persistance.dao.FavoriteCharactersDao

interface ILocalDatabase {
    fun getFavoriteCharactersDao(): FavoriteCharactersDao
}