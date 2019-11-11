package com.marvel.characters.presentation.favorite_characters

import android.database.Observable
import com.marvel.characters.framework.api.Character

interface FavoriteCharactersContract{
    interface View{
        fun initLayout()
    }
    interface Presenter {
        fun onCreate()
    }
    interface Interactor{
        fun getFavoriteCharacters(listener: Observable<List<Character>>)
    }
}
