package com.marvel.charecters.presentation.main

import com.marvel.charecters.domain.IContentManager
import com.marvel.charecters.framework.api.Wrapper
import io.reactivex.SingleObserver

class MainInteractor(private val contentManager: IContentManager): MainContract.Interactor {
    override fun getMarvelCharacters(offset: Int, nameStartWith: String?, listener: SingleObserver<Wrapper>) {
        contentManager.getMarvelCharacters(offset, nameStartWith, listener)
    }
}