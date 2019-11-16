package com.opensource.marvelcharacters.framework.persistance.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavoriteCharacters")
data class FavoriteCharacter(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val description: String?,
    val wikiUrl: String?,
    val thumbnail: String?)