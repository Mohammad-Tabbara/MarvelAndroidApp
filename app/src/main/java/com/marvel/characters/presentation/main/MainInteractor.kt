package com.marvel.characters.presentation.main

import com.marvel.characters.domain.IContentManager
import com.marvel.characters.framework.api.models.ApiWrapper
import io.reactivex.SingleObserver

class MainInteractor(private val contentManager: IContentManager): MainContract.Interactor {
    override fun getMarvelCharacters(offset: Int, nameStartWith: String?, listener: SingleObserver<ApiWrapper>) {
        contentManager.getMarvelCharacters(offset, nameStartWith, listener)
    }
}