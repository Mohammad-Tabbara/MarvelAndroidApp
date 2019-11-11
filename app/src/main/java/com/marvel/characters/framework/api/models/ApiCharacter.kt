package com.marvel.characters.framework.api.models

import com.google.gson.annotations.SerializedName


data class ApiCharacter(
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("urls") val urls: List<ApiResourceUrl>?,
    @SerializedName("thumbnail") val thumbnail: ApiThumbnail?)