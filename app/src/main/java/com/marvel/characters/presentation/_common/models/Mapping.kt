package com.marvel.characters.presentation._common.models

import com.marvel.characters.Constants
import com.marvel.characters.framework.api.models.*

fun ApiWrapper.toWrapper() = Wrapper(code,status,data.toContainer())
fun ApiContainer.toContainer() = Container(offset,limit,results.map { it.toCharacter() })
fun ApiCharacter.toCharacter() = Character(name,description,urls?.find { it.type == Constants.URL_TYPE.WIKI.value }?.url,thumbnail?.getFullPath())