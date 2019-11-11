package com.marvel.characters.presentation.favorite_characters

import com.marvel.characters.domain.ILogger
import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import io.reactivex.CompletableObserver
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class FavoriteCharactersPresenterImpl(val view: FavoriteCharactersContract.View, val interactor: FavoriteCharactersContract.Interactor, val logger: ILogger): FavoriteCharactersContract.Presenter {
    override fun onCreate() {
        interactor.getFavoriteCharacters(object : Observer<List<FavoriteCharacter>>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: List<FavoriteCharacter>) {
                logger.d("OnNEXT")
            }

            override fun onError(e: Throwable) {
                logger.e(e)
            }

        })

    }

}
