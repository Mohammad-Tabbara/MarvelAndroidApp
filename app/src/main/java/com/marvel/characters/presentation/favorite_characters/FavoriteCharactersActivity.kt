package com.marvel.characters.presentation.favorite_characters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.marvel.characters.R
import com.marvel.characters.base.BaseActivity
import javax.inject.Inject

class FavoriteCharactersActivity : BaseActivity(), FavoriteCharactersContract.View {

    @Inject
    lateinit var presenter: FavoriteCharactersContract.Presenter

    companion object{
        fun getInstance(context: Context) : Intent {
            return Intent(context,FavoriteCharactersActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_characters)
        presenter.onCreate()
    }

    override fun initLayout() {

    }
}
