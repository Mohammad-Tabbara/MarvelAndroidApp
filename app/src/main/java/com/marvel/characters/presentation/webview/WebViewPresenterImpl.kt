package com.marvel.characters.presentation.webview

import com.marvel.characters.domain.ILogger

class WebViewPresenterImpl(val view: WebViewContract.View, val logger: ILogger): WebViewContract.Presenter {

    var url: String? = null

    override fun onCreate(url: String?) {
        this.url = url
        view.initLayout()
        url?.let {
            view.initWebView(it)
        }
    }

    override fun webViewCanGoBack() {
        view.webViewBack()
    }

}