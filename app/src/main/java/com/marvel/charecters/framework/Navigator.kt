package com.marvel.charecters.framework

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.marvel.charecters.framework.api.Character
import com.marvel.charecters.presentation.character_details.CharacterDetailsActivity
import com.marvel.charecters.presentation.webview.WebViewActivity

class Navigator {
    private fun startActivity(context: Context, intent: Intent, shouldFinish: Boolean){
        context.startActivity(intent)
        if (context is Activity && shouldFinish) context.finish()
    }

    fun navigateToCharacterDetailsScreen(context: Context,character: Character,shouldFinish: Boolean){
        startActivity(context, CharacterDetailsActivity.getInstance(context,character),shouldFinish)
    }

    fun navigateToWebView(context: Context, url: String?, shouldFinish: Boolean) {
        startActivity(context, WebViewActivity.getInstance(context,url),shouldFinish)
    }
}