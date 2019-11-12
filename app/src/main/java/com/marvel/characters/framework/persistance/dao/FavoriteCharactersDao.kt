package com.marvel.characters.framework.persistance.dao

import androidx.room.*
import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface FavoriteCharactersDao {
    @Insert
    fun addFavoriteCharacter(favoriteCharacter: FavoriteCharacter)

    @Query("SELECT * FROM FavoriteCharacters")
    fun getFavoriteCharacters() : Observable<List<FavoriteCharacter>>

    @Query("SELECT Count(*) FROM FavoriteCharacters WHERE id=:characterId LIMIT 1")
    fun inFavorites(characterId: Int) : Observable<Boolean>

    @Query("DELETE FROM FavoriteCharacters WHERE id=:characterId")
    fun removeFavoriteCharacter(characterId: Int)
}