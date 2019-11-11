package com.marvel.characters.framework.api.models

import com.google.gson.annotations.SerializedName

data class ApiThumbnail(
    @SerializedName("path") val path: String?,
    @SerializedName("extension") val extension: String?) {

    fun getFullPath(): String{
        return "$path.$extension"
    }

}

