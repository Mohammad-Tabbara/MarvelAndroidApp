package com.marvel.charecters.framework

import com.marvel.charecters.BuildConfig
import com.marvel.charecters.Constants
import com.marvel.charecters.domain.IContentManager
import com.marvel.charecters.framework.api.ApiUtils
import com.marvel.charecters.framework.api.MarvelService
import com.marvel.charecters.framework.api.Wrapper
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class  ContentManager(val service: MarvelService, val apiUtils: ApiUtils): IContentManager {
    override fun getMarvellCharectersByPage(page: Int, listener: SingleObserver<Wrapper>) {
        val currentTimeInMillis = apiUtils.getCurrentTimeInMillis()
        subscribe(
            service.listCharacters(20,
                page,
                BuildConfig.PUBLIC_KEY,
                currentTimeInMillis,
                apiUtils.getMd5Hash(currentTimeInMillis.toString() + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY)),
            listener)
    }

    private fun <T: Any> subscribe(a:Single<T>, listener: SingleObserver<T>){
        a.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(listener)
    }
}