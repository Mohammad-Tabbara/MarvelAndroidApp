package com.opensource.marvelcharacters.presentation.webview

import com.opensource.marvelcharacters.domain.ILogger
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
        fun providePresenter(view: WebViewContract.View, logger: ILogger): WebViewContract.Presenter = WebViewPresenterImpl(view,logger)
    }

}