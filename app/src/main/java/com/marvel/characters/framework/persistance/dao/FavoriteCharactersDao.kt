package com.marvel.characters.framework.persistance.dao

import androidx.room.*
import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface FavoriteCharactersDao {
    @Insert
    fun addFavoriteCharacter(favoriteCharacter: FavoriteCharacter)

    @Delete
    fun removeFavoriteCharacter(favoriteCharacter: FavoriteCharacter)

    @Query("SELECT * FROM FavoriteCharacters")
    fun getFavoriteCharacters() : Observable<List<FavoriteCharacter>>
}