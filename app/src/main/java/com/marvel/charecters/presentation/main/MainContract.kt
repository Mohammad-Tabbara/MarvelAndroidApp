package com.marvel.charecters.presentation.main

import com.marvel.charecters.framework.api.Character
import com.marvel.charecters.framework.api.Wrapper
import io.reactivex.SingleObserver

interface MainContract {
    interface View{
        fun initLayout()
        fun displayCharacters(characters: List<Character>)
        fun startFetching()
        fun addCharacters(marvelCharacters: List<Character>)
        fun navigateToCharacterDetails(character: Character)
        fun loadMoreFailed()
        fun noInternetConnection()
    }
    interface Presenter{
        fun onCreate()
        fun fetchCharacters()
        fun marvalCharacterClicked(position: Int)
        fun loadMore(offset: Int)
    }
    interface Interactor{
        fun getMarvelCharacters(page: Int, listener: SingleObserver<Wrapper>)
    }
}