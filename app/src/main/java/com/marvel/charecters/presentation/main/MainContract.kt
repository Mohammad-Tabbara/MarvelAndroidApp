package com.marvel.charecters.presentation.main

import com.marvel.charecters.framework.api.Character
import com.marvel.charecters.framework.api.Wrapper
import io.reactivex.SingleObserver

interface MainContract {
    interface View{
        fun initLayout(characters: List<Character>)
        fun updateLayout(marvelCharacters: List<Character>)
        fun navigateToCharacterDetails(character: Character)
        fun loadMoreFailed()
    }
    interface Presenter{
        fun onCreate()
        fun marvalCharacterClicked(position: Int)
        fun loadMore(offset: Int)
    }
    interface Interactor{
        fun getMarvelCharacters(page: Int, listener: SingleObserver<Wrapper>)
    }
}