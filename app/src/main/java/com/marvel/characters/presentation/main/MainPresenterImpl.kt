package com.marvel.characters.presentation.main

import com.marvel.characters.domain.ILogger
import com.marvel.characters.framework.api.models.ApiWrapper
import com.marvel.characters.framework.rxJava.SingleListener
import com.marvel.characters.presentation._common.models.Character
import com.marvel.characters.presentation._common.models.Wrapper
import com.marvel.characters.presentation._common.models.toWrapper
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
        interactor.getMarvelCharacters(0,null, object : SingleListener<ApiWrapper>(){

            override fun onSuccess(apiWrapper: ApiWrapper) {
                val wrapper: Wrapper = apiWrapper.toWrapper()
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
        interactor.getMarvelCharacters(0,characterNameStartWith, object : SingleListener<ApiWrapper>(){

            override fun onSuccess(apiWrapper: ApiWrapper) {
                val wrapper: Wrapper = apiWrapper.toWrapper()
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
        interactor.getMarvelCharacters(offset, characterNameStartWith, object : SingleListener<ApiWrapper>(){

            override fun onSuccess(apiWrapper: ApiWrapper) {
                val wrapper: Wrapper = apiWrapper.toWrapper()
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

    override fun openFavorites() {
        view.navigateToFavoriteCharactersScreen()
    }
}