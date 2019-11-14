package com.opensource.marvelcharacters.framework.persistance.dao

import androidx.room.*
import com.opensource.marvelcharacters.framework.persistance.models.FavoriteCharacter
import io.reactivex.Observable

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