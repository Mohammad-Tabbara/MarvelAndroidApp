package com.marvel.characters.presentation.webview

interface WebViewContract {
    interface View{
        fun initLayout()
        fun initWebView(url: String)
        fun webViewBack()
    }
    interface Presenter{
        fun onCreate(url: String?)
        fun webViewCanGoBack()
    }
}