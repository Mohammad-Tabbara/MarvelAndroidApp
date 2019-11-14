package com.opensource.marvelcharacters.presentation.main

import com.opensource.marvelcharacters.presentation._common.models.Character
import com.opensource.marvelcharacters.framework.api.models.ApiWrapper
import com.opensource.marvelcharacters.framework.rxJava.SingleListener

interface MainContract {
    interface View{
        fun initLayout()
        fun displayCharacters(characters: MutableList<Character>)
        fun startFetching()
        fun updateCharacterList()
        fun navigateToCharacterDetails(character: Character)
        fun loadMoreFailed()
        fun noInternetConnection()
        fun navigateToFavoriteCharactersScreen()
    }
    interface Presenter{
        fun onCreate()
        fun fetchCharacters()
        fun searchCharacters(searchText: String)
        fun marvalCharacterClicked(position: Int)
        fun loadMore(offset: Int)
        fun openFavorites()

    }
    interface Interactor{
        fun getMarvelCharacters(offset: Int, nameStartWith: String?, listener: SingleListener<ApiWrapper>)
    }
}