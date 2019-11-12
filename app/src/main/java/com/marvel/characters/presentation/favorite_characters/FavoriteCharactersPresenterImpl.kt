package com.marvel.characters.presentation.favorite_characters

import com.marvel.characters.domain.ILogger
import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import com.marvel.characters.framework.rxJava.ObserverListener
import com.marvel.characters.presentation._common.models.Character
import com.marvel.characters.presentation._common.models.toCharacter
import io.reactivex.CompletableObserver
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class FavoriteCharactersPresenterImpl(val view: FavoriteCharactersContract.View, val interactor: FavoriteCharactersContract.Interactor, val logger: ILogger): FavoriteCharactersContract.Presenter {

    var characters : MutableList<Character> = mutableListOf()

    override fun onCreate() {
        view.initLayout()
        interactor.getFavoriteCharacters(object : ObserverListener<List<FavoriteCharacter>>(){
            override fun onNext(favoriteCharacters: List<FavoriteCharacter>) {
                characters = favoriteCharacters.map { it.toCharacter() }.toMutableList()
                view.displayFavoriteCharacters(characters)
            }

            override fun onError(e: Throwable) {
                logger.e(e)
            }

        })

    }

    override fun marvalCharacterClicked(position: Int) {
        view.navigateToCharacterDetailsActivity(characters[position])
    }

}
