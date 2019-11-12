package com.marvel.characters.presentation.character_details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.marvel.characters.R
import com.marvel.characters.base.BaseActivity
import com.marvel.characters.presentation._common.models.Character
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.character,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.findItem(R.id.action_favorite)?.icon = if(presenter.isFavorite) {
            ContextCompat.getDrawable(this, R.drawable.favorites)
        }else{
            ContextCompat.getDrawable(this, R.drawable.inactive_favorites)
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_favorite ->{
                presenter.toggleFavorite()
            }
        }
        return super.onOptionsItemSelected(item)
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
            Picasso.get().load(it.thumbnail).into(characterImage)
            characterDesc.text = it.description
        }
        if(hasWikiPage) openWiki.show()
        openWiki.setOnClickListener {
            presenter.openWikiClicked()
        }
    }

    override fun initFavorites(favorite: Boolean) {
        invalidateOptionsMenu()
    }

    override fun openInWebView(url: String?) {
        navigator.navigateToWebView(this,url,false)
    }
}
