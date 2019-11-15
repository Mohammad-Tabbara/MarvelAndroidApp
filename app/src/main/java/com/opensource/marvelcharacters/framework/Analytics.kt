package com.opensource.marvelcharacters.framework

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.opensource.marvelcharacters.domain.IAnalytics
import com.opensource.marvelcharacters.domain.IAnalyticsKeys

class Analytics(private val firebaseAnalytics: FirebaseAnalytics): IAnalytics {
    override fun didToggleFav(isFavorite: String, characterName: String?) {
        val bundle = Bundle()
        bundle.putString(IAnalyticsKeys.IS_FAVORITE, isFavorite)
        logEvent(IAnalyticsKeys.DID_TOGGLE_FAV, bundle)
    }

    override fun didClickFavScreenButton() {
        logEvent(IAnalyticsKeys.DID_CLICK_FAV_SCREEN_BUTTON, null)
    }

    override fun didClickListCharacter(screen: String, characterName: String?) {
        val bundle = Bundle()
        bundle.putString(IAnalyticsKeys.SCREEN, screen)
        bundle.putString(IAnalyticsKeys.CHARACTER_NAME, characterName)
        logEvent(IAnalyticsKeys.DID_CLICK_LIST_CHARACTER, bundle)

    }

    override fun didOpenWiki(characterName: String?) {
        val bundle = Bundle()
        bundle.putString(IAnalyticsKeys.CHARACTER_NAME, characterName)
        logEvent(IAnalyticsKeys.DID_OPEN_WIKI, bundle)
    }

    private fun logEvent(action: String, bundle: Bundle?) {
        firebaseAnalytics.logEvent(action,bundle)
    }
}