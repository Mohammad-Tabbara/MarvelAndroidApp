package com.opensource.marvelcharacters.domain

import com.opensource.marvelcharacters.framework.persistance.dao.FavoriteCharactersDao

interface ILocalDatabase {
    fun getFavoriteCharactersDao(): FavoriteCharactersDao
}