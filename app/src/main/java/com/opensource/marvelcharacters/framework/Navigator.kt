package com.opensource.marvelcharacters.framework

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.opensource.marvelcharacters.presentation._common.models.Character
import com.opensource.marvelcharacters.presentation.character_details.CharacterDetailsActivity
import com.opensource.marvelcharacters.presentation.favorite_characters.FavoriteCharactersActivity
import com.opensource.marvelcharacters.presentation.webview.WebViewActivity

class Navigator {
    private fun startActivity(context: Context, intent: Intent, shouldFinish: Boolean){
        context.startActivity(intent)
        if (context is Activity && shouldFinish) context.finish()
    }

    fun navigateToCharacterDetailsScreen(context: Context, character: Character, shouldFinish: Boolean){
        startActivity(context, CharacterDetailsActivity.getInstance(context,character),shouldFinish)
    }

    fun navigateToWebView(context: Context, url: String?, shouldFinish: Boolean) {
        startActivity(context, WebViewActivity.getInstance(context,url),shouldFinish)
    }

    fun navigateToFavoriteCharacters(context: Context, shouldFinish: Boolean) {
        startActivity(context, FavoriteCharactersActivity.getInstance(context),shouldFinish)
    }
}