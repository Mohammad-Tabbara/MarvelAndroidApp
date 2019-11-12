package com.marvel.characters.presentation.favorite_characters

import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import com.marvel.characters.framework.rxJava.ObserverListener
import com.marvel.characters.presentation._common.models.Character

interface FavoriteCharactersContract{
    interface View{
        fun initLayout()
        fun displayFavoriteCharacters(characters: MutableList<Character>)
        fun navigateToCharacterDetailsActivity(character: Character)
    }
    interface Presenter {
        fun onCreate()
        fun marvalCharacterClicked(position: Int)
    }
    interface Interactor{
        fun getFavoriteCharacters(listener: ObserverListener<List<FavoriteCharacter>>)
    }
}
