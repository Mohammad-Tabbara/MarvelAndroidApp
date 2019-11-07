package com.marvel.charecters.presentation.main

import com.marvel.charecters.framework.api.Character
import com.marvel.charecters.framework.api.Wrapper
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
        fun getMarvelCharacters(offset: Int, nameStartWith: String?, listener: SingleObserver<Wrapper>)
    }
}