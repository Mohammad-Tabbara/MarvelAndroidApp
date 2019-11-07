package com.marvel.characters.presentation.character_details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.marvel.characters.R
import com.marvel.characters.base.BaseActivity
import com.marvel.characters.framework.api.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_character_details.*
import kotlinx.android.synthetic.main.activity_character_details.toolbar
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

    override fun initLayout(character: Character?, hasWikiPage: Boolean) {
        toolbar.title = character?.name
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val typeface = ResourcesCompat.getFont(this, R.font.marvel)
        collapsingToolbar.setCollapsedTitleTypeface(typeface)
        collapsingToolbar.setExpandedTitleTypeface(typeface)

        character?.let {
            Picasso.get().load(it.thumbnail?.getFullPath()).into(characterImage)
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
