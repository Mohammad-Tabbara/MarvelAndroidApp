package com.marvel.characters.framework.api.models

import com.google.gson.annotations.SerializedName


data class ApiResourceUrl(
    @SerializedName("type") val type: String?,
    @SerializedName("url") val url: String?)