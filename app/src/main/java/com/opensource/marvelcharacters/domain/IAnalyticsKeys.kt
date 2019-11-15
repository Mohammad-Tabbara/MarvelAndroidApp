package com.opensource.marvelcharacters.domain

interface IAnalyticsKeys {

    companion object{

        //ActionKeys
        const val DID_TOGGLE_FAV: String = "DidToggleFav"
        const val DID_CLICK_FAV_SCREEN_BUTTON: String = "DidClickFavScreenButton"
        const val DID_CLICK_LIST_CHARACTER: String = "DidClickListCharacter"
        const val DID_OPEN_WIKI: String = "DidOpenWiki"

        //ValueKeys
        const val IS_FAVORITE: String = "IsFavorite"
        const val SCREEN: String = "Screen"
        const val CHARACTER_NAME: String = "CharacterName"

        //Value
        const val MAIN: String = "Main"
        const val FAVORITE: String = "Favorite"
        const val TRUE: String ="True"
        const val FALSE: String ="False"
    }

}