package com.marvel.characters.framework

import com.marvel.characters.BuildConfig
import com.marvel.characters.Constants
import com.marvel.characters.domain.IContentManager
import com.marvel.characters.domain.ILocalDatabase
import com.marvel.characters.framework.api.ApiUtils
import com.marvel.characters.framework.api.MarvelService
import com.marvel.characters.framework.api.models.ApiWrapper
import com.marvel.characters.framework.persistance.models.FavoriteCharacter
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class  ContentManager(private val service: MarvelService, private val localDatabase: ILocalDatabase, private val apiUtils: ApiUtils): IContentManager {

    override fun getMarvelCharacters(offset: Int, nameStartWith: String?, listener: SingleObserver<ApiWrapper>) {
        val currentTimeInMillis = apiUtils.getCurrentTimeInMillis()
        subscribe(
            service.getMarvelCharactersByPage(20,
                offset,
                nameStartWith,
                BuildConfig.PUBLIC_KEY,
                currentTimeInMillis,
                apiUtils.getMd5Hash(currentTimeInMillis.toString() + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY)),
            listener)
    }

    override fun fetchFavoriteCharacters(listener: Observer<List<FavoriteCharacter>>) {
        subscribe(localDatabase.getFavoriteCharactersDao().getFavoriteCharacters(),listener)
    }

    override fun addCharacterToFavorites(favoriteCharacter: FavoriteCharacter, listener: CompletableObserver) {
        subscribe(Completable.fromAction {localDatabase.getFavoriteCharactersDao().addFavoriteCharacter(favoriteCharacter)},listener)
    }

    private fun subscribe(completable:Completable, listener: CompletableObserver){
        completable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(listener)
    }
    private fun <T: Any> subscribe(single:Single<T>, listener: SingleObserver<T>){
        single.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(listener)
    }

    private fun <T: Any> subscribe(observable: Observable<T>, listener: Observer<T>){
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(listener)
    }
}