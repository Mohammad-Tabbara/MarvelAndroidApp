package com.marvel.characters.framework.api.models

data class ApiContainer(val offset: Int, val limit: Int, val results: List<ApiCharacter>)