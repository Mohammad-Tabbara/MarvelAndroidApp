package com.marvel.charecters.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.marvel.charecters.R
import com.marvel.charecters.base.BaseActivity
import com.marvel.charecters.domain.ILogger
import com.marvel.charecters.framework.api.Character
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.no_network_connection.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View,
    MarvelCharactersAdapter.MarvelAdapterListener {

    companion object{
        fun getInstance(context:Context):Intent = Intent(context,MainActivity::class.java)
    }

    @Inject
    lateinit var presenter: MainContract.Presenter

    var adapter : MarvelCharactersAdapter? = null

    @Inject
    lateinit var logger: ILogger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onCreate()
    }

    override fun initLayout() {
        presenter.fetchCharacters()
        retryButton.setOnClickListener {
            presenter.fetchCharacters()
        }
        adapter = MarvelCharactersAdapter(mutableListOf(),this)
        charactersList.adapter = adapter
        charactersList.layoutManager = LinearLayoutManager(this)
    }

    override fun startFetching() {
        noNetwork.visibility = View.GONE
        fetchingProgress.visibility = View.VISIBLE
        charactersList.visibility = View.GONE
    }

    override fun displayCharacters(characters: List<Character>) {
        adapter = MarvelCharactersAdapter(characters.toMutableList(),this)
        charactersList.adapter = adapter
        charactersList.layoutManager = LinearLayoutManager(this)
        noNetwork.visibility = View.GONE
        fetchingProgress.visibility = View.GONE
        charactersList.visibility = View.VISIBLE
    }

    override fun addCharacters(marvelCharacters: List<Character>) {
        adapter?.updateData(marvelCharacters)
    }

    override fun loadMoreFailed() {
        adapter?.loadMoreFailed()
    }

    override fun noInternetConnection() {
        noNetwork.visibility = View.VISIBLE
        fetchingProgress.visibility = View.GONE
        charactersList.visibility = View.GONE
    }

    override fun marvalCharacterClick(position: Int) {
        presenter.marvalCharacterClicked(position)
    }

    override fun loadMore(offset: Int) {
        presenter.loadMore(offset)
    }

    override fun navigateToCharacterDetails(character: Character) {
        navigator.navigateToCharacterDetailsScreen(this, character,false)
    }

}
