package com.marvel.characters.presentation.webview

import com.marvel.characters.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class WebViewModule {

    @Binds
    abstract fun bindView(mainActivity: WebViewActivity): WebViewContract.View

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun bindPresenter(view: WebViewContract.View, logger: ILogger): WebViewContract.Presenter = WebViewPresenterImpl(view,logger)
    }

}