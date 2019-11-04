package com.marvel.charecters.presentation.character_details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.marvel.charecters.R
import com.marvel.charecters.base.BaseActivity
import com.marvel.charecters.framework.api.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_character_details.*
import javax.inject.Inject

class CharacterDetailsActivity : BaseActivity(),CharacterDetailsContract.View {


    @Inject
    lateinit var presenter: CharacterDetailsContract.Presenter

    companion object{
        private val CHARACTER = "CHARACTER"
        fun getInstance(context: Context,character: Character): Intent {
            val intent = Intent(context, CharacterDetailsActivity::class.java)
            intent.putExtra(CHARACTER,character)
             return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)
        presenter.onCreate(intent.getParcelableExtra(CHARACTER))
    }

    override fun initLayout(character: Character?, hasWikiPage : Boolean) {
        character?.let {
            Picasso.get().load(it.thumbnail?.getFullPath()).into(characterImage)
            characterName.text = it.name
            characterDesc.text = it.description
        }
        if(hasWikiPage) openWiki.show()
        openWiki.setOnClickListener {
            presenter.openWikiClicked()
        }
    }

    override fun openInWebView(url: String?) {
        navigator.navigateToWebView(this,url,false)
    }
}