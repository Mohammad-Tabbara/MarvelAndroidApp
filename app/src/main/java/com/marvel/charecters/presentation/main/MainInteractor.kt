package com.marvel.charecters.presentation.main

import com.marvel.charecters.domain.IContentManager
import com.marvel.charecters.framework.api.Wrapper
import io.reactivex.SingleObserver
import io.reactivex.observers.DisposableCompletableObserver

class MainInteractor(val contentManager: IContentManager): MainContract.Interactor {
    override fun getMarvelCharacters(page: Int, listener: SingleObserver<Wrapper>) {
        contentManager.getMarvellCharectersByPage(page, listener)
    }
}