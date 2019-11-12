package com.marvel.characters.presentation.character_details

import com.marvel.characters.domain.ILogger
import com.marvel.characters.framework.rxJava.LocalDbListener
import com.marvel.characters.framework.rxJava.ObserverListener
import com.marvel.characters.framework.rxJava.SingleListener
import com.marvel.characters.presentation._common.models.Character
import com.marvel.characters.presentation._common.models.toFavoriteCharacter
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class CharacterDetailsPresenterImpl(val view: CharacterDetailsContract.View, val interactor: CharacterDetailsContract.Interactor, val logger: ILogger): CharacterDetailsContract.Presenter {

    var character: Character? = null
    var wikiPage : String? = null
    override var isFavorite: Boolean = false

    override fun onCreate(character: Character?) {
        this.character = character
        wikiPage = character?.url
        view.initLayout(character, wikiPage != null)
        character?.id?.let {
            interactor.inFavorites(it, object : ObserverListener<Boolean>() {
                override fun onNext(exist: Boolean) {
                    isFavorite = exist
                    view.initFavorites(isFavorite)
                }

                override fun onError(e: Throwable) {
                    logger.e(e)
                }

            })
        }

    }

    override fun openWikiClicked() {
        view.openInWebView(wikiPage)
    }

    override fun toggleFavorite() {
        character?.toFavoriteCharacter()?.let {
            if(!isFavorite) {
                interactor.addToFavorites(it, object : LocalDbListener() {
                    override fun onError(e: Throwable) {
                        logger.e(e)
                    }
                })
            }else{
                interactor.removeFromFavorites(it.id, object : LocalDbListener() {
                    override fun onError(e: Throwable) {
                        logger.e(e)
                    }
                })
            }
        }
    }
}