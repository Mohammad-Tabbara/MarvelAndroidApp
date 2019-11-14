package com.opensource.marvelcharacters.presentation.favorite_characters

import com.opensource.marvelcharacters.framework.persistance.models.FavoriteCharacter
import com.opensource.marvelcharacters.framework.rxJava.ObserverListener
import com.opensource.marvelcharacters.presentation._common.models.Character

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
