package com.marvel.characters.presentation.favorite_characters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.marvel.characters.R
import com.marvel.characters.base.BaseActivity
import com.marvel.characters.presentation._common.adapters.MarvelCharactersAdapter
import com.marvel.characters.presentation._common.models.Character
import kotlinx.android.synthetic.main.activity_favorite_characters.*
import kotlinx.android.synthetic.main.activity_favorite_characters.toolbar
import javax.inject.Inject

class FavoriteCharactersActivity : BaseActivity(), FavoriteCharactersContract.View, MarvelCharactersAdapter.MarvelAdapterListener {
    companion object{
        fun getInstance(context: Context) : Intent {
            return Intent(context,FavoriteCharactersActivity::class.java)
        }
    }

    @Inject
    lateinit var presenter: FavoriteCharactersContract.Presenter

    var adapter : MarvelCharactersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_characters)
        presenter.onCreate()
    }

    override fun initLayout() {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun displayFavoriteCharacters(characters: MutableList<Character>) {
        adapter = MarvelCharactersAdapter(
            characters,
            this
        )
        favoriteCharactersList.adapter = adapter
        favoriteCharactersList.layoutManager = LinearLayoutManager(this)
    }

    override fun navigateToCharacterDetailsActivity(character: Character) {
        navigator.navigateToCharacterDetailsScreen(this,character,false)
    }


    override fun marvalCharacterClick(position: Int) {
        presenter.marvalCharacterClicked(position)
    }
}
