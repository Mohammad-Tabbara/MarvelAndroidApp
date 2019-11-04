package com.marvel.charecters.presentation.main

import com.marvel.charecters.domain.ILogger
import com.marvel.charecters.framework.api.Character
import com.marvel.charecters.framework.api.Wrapper
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MainPresenterImpl(val view: MainContract.View, val interactor: MainContract.Interactor, val logger: ILogger): MainContract.Presenter {

    private var marvelCharacters: MutableList<Character> = mutableListOf()

    override fun onCreate() {
        interactor.getMarvelCharacters(0, object : SingleObserver<Wrapper>{
            override fun onSubscribe(d: Disposable) {}

            override fun onSuccess(wrapper: Wrapper) {
                marvelCharacters = wrapper.data.results.toMutableList()
                view.initLayout(marvelCharacters)
            }

            override fun onError(e: Throwable) {
               logger.e(e)
            }
        })
    }

    override fun loadMore(offset: Int) {
        interactor.getMarvelCharacters(offset, object : SingleObserver<Wrapper>{
            override fun onSubscribe(d: Disposable) {}

            override fun onSuccess(wrapper: Wrapper) {
                marvelCharacters.addAll(wrapper.data.results)
                view.updateLayout(wrapper.data.results)
            }

            override fun onError(e: Throwable) {
                view.loadMoreFailed()
                logger.e(e)
            }
        })
    }

    override fun marvalCharacterClicked(position: Int) {
        view.navigateToCharacterDetails(marvelCharacters[position])
    }
}