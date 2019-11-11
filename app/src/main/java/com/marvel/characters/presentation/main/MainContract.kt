package com.marvel.characters.presentation.main

import com.marvel.characters.presentation._common.models.Character
import com.marvel.characters.framework.api.models.ApiWrapper
import io.reactivex.SingleObserver

interface MainContract {
    interface View{
        fun initLayout()
        fun displayCharacters(characters: MutableList<Character>)
        fun startFetching()
        fun updateCharacterList()
        fun navigateToCharacterDetails(character: Character)
        fun loadMoreFailed()
        fun noInternetConnection()
    }
    interface Presenter{
        fun onCreate()
        fun fetchCharacters()
        fun searchCharacters(searchText: String)
        fun marvalCharacterClicked(position: Int)
        fun loadMore(offset: Int)

    }
    interface Interactor{
        fun getMarvelCharacters(offset: Int, nameStartWith: String?, listener: SingleObserver<ApiWrapper>)
    }
}