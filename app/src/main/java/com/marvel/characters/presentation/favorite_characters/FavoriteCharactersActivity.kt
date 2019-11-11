package com.marvel.characters.presentation.favorite_characters

import android.os.Bundle
import com.marvel.characters.R
import com.marvel.characters.base.BaseActivity

class FavoriteCharactersActivity : BaseActivity(), FavoriteCharactersContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_characters)
    }

    override fun initLayout() {

    }
}
