package com.marvel.characters.presentation.character_details

import com.marvel.characters.domain.ILogger
import com.marvel.characters.framework.api.Character

class CharacterDetailsPresenterImpl(val view: CharacterDetailsContract.View, val logger: ILogger): CharacterDetailsContract.Presenter {
    var character: Character? = null
    var wikiPage : String? = null
    override fun onCreate(character: Character?) {
        this.character = character
        character?.urls?.let {
            for(resourceUrl in it){
                if(resourceUrl.type == "wiki"){
                    wikiPage = resourceUrl.url
                }
            }
        }
        view.initLayout(character, wikiPage != null)
    }

    override fun openWikiClicked() {
        view.openInWebView(wikiPage)
    }
}