package com.opensource.marvelcharacters.presentation.main

import com.opensource.marvelcharacters.domain.IAnalyticsKeys
import com.opensource.marvelcharacters.domain.ILogger
import com.opensource.marvelcharacters.framework.api.models.ApiWrapper
import com.opensource.marvelcharacters.framework.rxJava.ApiListener
import com.opensource.marvelcharacters.presentation._common.models.Character
import com.opensource.marvelcharacters.presentation._common.models.Wrapper
import com.opensource.marvelcharacters.presentation._common.models.toWrapper
import io.reactivex.disposables.CompositeDisposable

class MainPresenterImpl(val view: MainContract.View, val interactor: MainContract.Interactor, val logger: ILogger): MainContract.Presenter {

    private var marvelCharacters: MutableList<Character> = mutableListOf()
    private var characterNameStartWith : String? = null

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        view.initLayout()
    }

    override fun fetchCharacters() {
        view.startFetching()
        val marvelCharactersListener = object : ApiListener<ApiWrapper>(){

            override fun onSuccess(apiWrapper: ApiWrapper) {
                val wrapper: Wrapper = apiWrapper.toWrapper()
                marvelCharacters = wrapper.data.results.toMutableList()
                view.displayCharacters(marvelCharacters)
            }

            override fun onError(e: Throwable) {
                view.noInternetConnection()
                logger.e(e)
            }

            override fun onNoNetwork() {
                view.noInternetConnection()
            }
        }
        compositeDisposable.add(marvelCharactersListener)
        interactor.getMarvelCharacters(0,null, marvelCharactersListener)
    }

    override fun searchCharacters(searchText: String) {
        if(!compositeDisposable.isDisposed){
            compositeDisposable.clear()
        }
        characterNameStartWith = if(searchText.isNotEmpty()) searchText else null
        view.startFetching()
        val marvelCharactersListener = object : ApiListener<ApiWrapper>(){

            override fun onSuccess(apiWrapper: ApiWrapper) {
                val wrapper: Wrapper = apiWrapper.toWrapper()
                marvelCharacters = wrapper.data.results.toMutableList()
                view.displayCharacters(marvelCharacters)
            }

            override fun onError(e: Throwable) {
                view.noInternetConnection()
                logger.e(e)
            }

            override fun onNoNetwork() {
                view.noInternetConnection()
            }
        }
        compositeDisposable.add(marvelCharactersListener)
        interactor.getMarvelCharacters(0,characterNameStartWith, marvelCharactersListener)
    }

    override fun loadMore(offset: Int) {
        val marvelCharactersListener = object : ApiListener<ApiWrapper>(){

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

            override fun onNoNetwork() {
                view.loadMoreFailed()
            }
        }
        compositeDisposable.add(marvelCharactersListener)
        interactor.getMarvelCharacters(offset, characterNameStartWith, marvelCharactersListener)
    }

    override fun marvalCharacterClicked(position: Int) {
        view.didClickListCharacter(IAnalyticsKeys.MAIN,marvelCharacters[position].name)
        view.navigateToCharacterDetails(marvelCharacters[position])
    }

    override fun openFavoritesButtonClick() {
        view.didClickFavScreenButton()
        view.navigateToFavoriteCharactersScreen()
    }
}