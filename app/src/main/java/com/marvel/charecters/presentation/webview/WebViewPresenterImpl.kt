package com.marvel.charecters.presentation.webview

import com.marvel.charecters.domain.ILogger

class WebViewPresenterImpl(val view: WebViewContract.View, val logger: ILogger): WebViewContract.Presenter {

    var url: String? = null

    override fun onCreate(url: String?) {
        this.url = url
        url?.let {
            view.initLayout(it)
        }
    }

    override fun webViewCanGoBack() {
        view.webViewBack()
    }

}