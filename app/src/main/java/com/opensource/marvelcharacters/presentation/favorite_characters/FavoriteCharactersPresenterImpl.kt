package com.opensource.marvelcharacters.presentation.favorite_characters

import com.opensource.marvelcharacters.domain.ILogger
import com.opensource.marvelcharacters.framework.persistance.models.FavoriteCharacter
import com.opensource.marvelcharacters.framework.rxJava.ObserverListener
import com.opensource.marvelcharacters.presentation._common.models.Character
import com.opensource.marvelcharacters.presentation._common.models.toCharacter

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
