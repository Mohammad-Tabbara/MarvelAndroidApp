package com.marvel.characters.framework.api

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Wrapper(val code: Int, val status: String, val data :Container)
data class Container(val offset: Int, val limit: Int, val results: List<Character>)
data class Character(
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("urls") val urls: List<ResourceUrl>?,
    @SerializedName("thumbnail") val thumbnail: Thumbnail?) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        arrayListOf<ResourceUrl>().apply {
            parcel.readList(this,ResourceUrl::class.java.classLoader)
        },
        parcel.readParcelable(Thumbnail::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeList(urls)
        parcel.writeParcelable(thumbnail,flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }
}

data class ResourceUrl(
    @SerializedName("type") val type: String?,
    @SerializedName("url") val url: String?):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResourceUrl> {
        override fun createFromParcel(parcel: Parcel): ResourceUrl {
            return ResourceUrl(parcel)
        }

        override fun newArray(size: Int): Array<ResourceUrl?> {
            return arrayOfNulls(size)
        }
    }
}

data class Thumbnail(
    @SerializedName("path") val path: String?,
    @SerializedName("extension") val extension: String?):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    fun getFullPath(): String{
        return "$path.$extension"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(path)
        parcel.writeString(extension)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Thumbnail> {
        override fun createFromParcel(parcel: Parcel): Thumbnail {
            return Thumbnail(parcel)
        }

        override fun newArray(size: Int): Array<Thumbnail?> {
            return arrayOfNulls(size)
        }
    }
}
