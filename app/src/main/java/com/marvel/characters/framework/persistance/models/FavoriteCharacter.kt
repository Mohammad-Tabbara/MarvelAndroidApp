package com.marvel.characters.framework.persistance.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavoriteCharacters")
data class FavoriteCharacter(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String?,
    val description: String?,
    val wikiUrl: String?,
    val thumbnail: String?)