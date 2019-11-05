package com.marvel.charecters.presentation.webview

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient

import com.marvel.charecters.base.BaseActivity
import kotlinx.android.synthetic.main.activity_web_view.*
import javax.inject.Inject
import android.webkit.WebView
import android.webkit.WebViewClient
import com.marvel.charecters.R
import java.net.URL


class WebViewActivity : BaseActivity(), WebViewContract.View {


    @Inject
    lateinit var presenter: WebViewContract.Presenter

    companion object{
        const val WEB_PAGE: String = "URL"
        const val requestId: Long = 101
        fun getInstance(context: Context, url: String?): Intent {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra(WEB_PAGE,url)
             return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        initToolbar()
        presenter.onCreate(intent.getStringExtra(WEB_PAGE))
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            presenter.webViewCanGoBack()
        } else {
            super.onBackPressed()
        }

    }

    override fun initWebView(url: String) {
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                toolbar.title = URL(url).authority
            }
        }

        webView.webChromeClient = object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if(newProgress < 100 &&  webViewProgressBar.visibility == View.GONE){
                    webViewProgressBar.visibility = View.VISIBLE
                }
                webViewProgressBar.progress = newProgress
                if(newProgress == 100){
                    webViewProgressBar.visibility = View.GONE
                }
            }
        }
        webView.apply {
            settings.apply {
                loadsImagesAutomatically = true
                javaScriptEnabled = true
                loadWithOverviewMode = true
                useWideViewPort = true
                builtInZoomControls = false
                displayZoomControls = false
                domStorageEnabled = true
                allowFileAccess = true
            }
            setInitialScale(1)
            loadUrl(url)
        }
    }

    override fun webViewBack() {
        webView.goBack()
    }
}
