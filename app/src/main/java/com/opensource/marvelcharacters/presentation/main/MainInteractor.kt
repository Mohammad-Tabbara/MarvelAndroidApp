package com.opensource.marvelcharacters.presentation.main

import com.opensource.marvelcharacters.domain.IContentManager
import com.opensource.marvelcharacters.framework.api.models.ApiWrapper
import com.opensource.marvelcharacters.framework.rxJava.ApiListener

class MainInteractor(private val contentManager: IContentManager): MainContract.Interactor {
    override fun getMarvelCharacters(offset: Int, nameStartWith: String?, listener: ApiListener<ApiWrapper>) {
        contentManager.getMarvelCharacters(offset, nameStartWith, listener)
    }
}