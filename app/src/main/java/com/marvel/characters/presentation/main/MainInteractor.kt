package com.marvel.characters.presentation.main

import com.marvel.characters.domain.IContentManager
import com.marvel.characters.framework.api.Wrapper
import io.reactivex.SingleObserver

class MainInteractor(val contentManager: IContentManager): MainContract.Interactor {
    override fun getMarvelCharacters(page: Int, listener: SingleObserver<Wrapper>) {
        contentManager.getMarvellCharectersByPage(page, listener)
    }
}