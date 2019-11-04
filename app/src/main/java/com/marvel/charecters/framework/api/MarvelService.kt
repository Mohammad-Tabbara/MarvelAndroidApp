package com.marvel.charecters.framework.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {
    @GET("/v1/public/characters")
    fun listCharacters(@Query("limit") limit: Int, @Query("offset") offset: Int,
                       @Query("apikey") apiKey: String,
                       @Query("ts") ts: Long,
                       @Query("hash") hash: String): Single<Wrapper>

}