package com.opensource.marvelcharacters.domain

interface IAnalytics {
    fun didToggleFav(isFavorite: String, characterName: String?)
    fun didClickFavScreenButton()
    fun didClickListCharacter(screen: String, characterName: String?)
    fun didOpenWiki(characterName:String?)
}