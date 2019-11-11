package com.marvel.characters.presentation.favorite_characters

import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.Observer
import io.reactivex.Single

interface FavoriteCharactersContract{
    interface View{
        fun initLayout()
    }
    interface Presenter {
        fun onCreate()
    }
    interface Interactor{
        fun getFavoriteCharacters(listener: Observer<List<FavoriteCharacter>>)
    }
}
