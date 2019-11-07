package com.marvel.characters.presentation.character_details

import com.marvel.characters.framework.api.Character

interface CharacterDetailsContract {
    interface View{
        fun initLayout(character: Character?,hasWikiPage: Boolean)
        fun openInWebView(url: String?)
    }
    interface Presenter{
        fun onCreate(character: Character?)
        fun openWikiClicked()

    }
}