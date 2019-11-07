package com.marvel.characters.presentation.main

import com.marvel.characters.domain.ILogger
import com.marvel.characters.framework.api.Character
import com.marvel.characters.framework.api.Wrapper
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MainPresenterImpl(val view: MainContract.View, val interactor: MainContract.Interactor, val logger: ILogger): MainContract.Presenter {

    private var marvelCharacters: MutableList<Character> = mutableListOf()
    private var characterNameStartWith : String? = null

    override fun onCreate() {
        view.initLayout()
    }

    override fun fetchCharacters() {
        view.startFetching()
        interactor.getMarvelCharacters(0,null, object : SingleObserver<Wrapper>{
            override fun onSubscribe(d: Disposable) {}

            override fun onSuccess(wrapper: Wrapper) {
                marvelCharacters = wrapper.data.results.toMutableList()
                view.displayCharacters(marvelCharacters)
            }

            override fun onError(e: Throwable) {
                view.noInternetConnection()
                logger.e(e)
            }
        })
    }

    override fun searchCharacters(searchText: String) {
        characterNameStartWith = if(searchText.isNotEmpty()) searchText else null
        view.startFetching()
        interactor.getMarvelCharacters(0,characterNameStartWith, object : SingleObserver<Wrapper>{
            override fun onSubscribe(d: Disposable) {}

            override fun onSuccess(wrapper: Wrapper) {
                marvelCharacters = wrapper.data.results.toMutableList()
                view.displayCharacters(marvelCharacters)
            }

            override fun onError(e: Throwable) {
                view.noInternetConnection()
                logger.e(e)
            }
        })
    }

    override fun loadMore(offset: Int) {
        interactor.getMarvelCharacters(offset, characterNameStartWith, object : SingleObserver<Wrapper>{
            override fun onSubscribe(d: Disposable) {}

            override fun onSuccess(wrapper: Wrapper) {
                if(wrapper.data.results.isNotEmpty()) {
                    marvelCharacters.addAll(wrapper.data.results)
                }
                view.updateCharacterList()
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