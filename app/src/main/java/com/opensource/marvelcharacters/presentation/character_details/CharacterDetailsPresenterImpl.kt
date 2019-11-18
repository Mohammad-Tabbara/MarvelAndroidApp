package com.opensource.marvelcharacters.presentation.character_details

import com.opensource.marvelcharacters.domain.IAnalyticsKeys
import com.opensource.marvelcharacters.domain.ILogger
import com.opensource.marvelcharacters.framework.rxJava.LocalDbListener
import com.opensource.marvelcharacters.framework.rxJava.ObserverListener
import com.opensource.marvelcharacters.presentation._common.models.Character
import com.opensource.marvelcharacters.presentation._common.models.toFavoriteCharacter
import io.reactivex.disposables.CompositeDisposable

class CharacterDetailsPresenterImpl(val view: CharacterDetailsContract.View, val interactor: CharacterDetailsContract.Interactor, val logger: ILogger): CharacterDetailsContract.Presenter {

    var character: Character? = null
    var wikiPage : String? = null

    private val compositeDisposable = CompositeDisposable()

    override var isFavorite: Boolean = false

    override fun onCreate(character: Character?) {
        this.character = character
        wikiPage = character?.url
        view.initLayout(character, wikiPage != null)
        character?.id?.let {
            val inFavorites = object : ObserverListener<Boolean>() {
                override fun onNext(exist: Boolean) {
                    isFavorite = exist
                    view.initFavorites(isFavorite)
                }

                override fun onError(e: Throwable) {
                    logger.e(e)
                }

            }
            compositeDisposable.add(inFavorites)
            interactor.inFavorites(it, inFavorites)
        }

    }

    override fun openWikiClicked() {
        view.didOpenWiki(character?.name)
        view.openInWebView(wikiPage)
    }

    override fun toggleFavorite() {
        character?.toFavoriteCharacter()?.let {
            if(!isFavorite) {
                val addToFavorites = object : LocalDbListener() {
                    override fun onComplete() {
                        view.didToggleFav(IAnalyticsKeys.TRUE, it.name)
                    }

                    override fun onError(e: Throwable) {
                        logger.e(e)
                    }
                }
                compositeDisposable.add(addToFavorites)
                interactor.addToFavorites(it, addToFavorites)
            }else{
                val removeFromFavorites = object : LocalDbListener() {
                    override fun onComplete() {
                        view.didToggleFav(IAnalyticsKeys.FALSE, it.name)
                    }

                    override fun onError(e: Throwable) {
                        logger.e(e)
                    }
                }
                compositeDisposable.add(removeFromFavorites)
                interactor.removeFromFavorites(it.id, removeFromFavorites)
            }
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }
}