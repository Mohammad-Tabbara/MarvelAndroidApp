package com.marvel.charecters.presentation.webview

import com.marvel.charecters.framework.api.Character
import com.marvel.charecters.framework.api.Wrapper
import io.reactivex.SingleObserver

interface WebViewContract {
    interface View{
        fun initLayout(url: String)
        fun webViewBack()
    }
    interface Presenter{
        fun onCreate(url: String?)
        fun webViewCanGoBack()
    }
}