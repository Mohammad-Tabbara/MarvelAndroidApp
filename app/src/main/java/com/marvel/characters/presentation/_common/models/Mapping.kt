package com.marvel.characters.presentation._common.models

import com.marvel.characters.Constants
import com.marvel.characters.framework.api.models.*
import com.marvel.characters.framework.persistance.models.FavoriteCharacter

fun ApiWrapper.toWrapper() = Wrapper(code,status,data.toContainer())
fun ApiContainer.toContainer() = Container(offset,limit,results.map { it.toCharacter() })
fun ApiCharacter.toCharacter() = Character(id,name,description,urls?.find { it.type == Constants.URL_TYPE.WIKI.value }?.url,thumbnail?.getFullPath())

fun FavoriteCharacter.toCharacter() = Character(id,name,description,wikiUrl,thumbnail)
fun Character.toFavoriteCharacter() = FavoriteCharacter(id,name,description,url,thumbnail)