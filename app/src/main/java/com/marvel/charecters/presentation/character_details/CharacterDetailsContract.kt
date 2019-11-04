package com.marvel.charecters.presentation.character_details

import com.marvel.charecters.framework.api.Character
import com.marvel.charecters.framework.api.Wrapper
import io.reactivex.SingleObserver

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