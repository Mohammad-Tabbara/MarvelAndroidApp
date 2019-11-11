package com.marvel.characters.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.marvel.characters.R
import com.marvel.characters.base.BaseActivity
import com.marvel.characters.domain.ILogger
import com.marvel.characters.presentation._common.models.Character
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.no_network_connection.*
import javax.inject.Inject
import androidx.appcompat.widget.SearchView
import androidx.core.view.iterator





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
        toolbar.inflateMenu(R.menu.main)
        for(item in toolbar.menu.iterator()){
            when(item.itemId){
                R.id.action_search -> {
                    val searchView = item.actionView as SearchView?
                    searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String): Boolean {
                            return false
                        }

                        override fun onQueryTextChange(searchText: String): Boolean {
                            presenter.searchCharacters(searchText)
                            return false
                        }
                    })
                    searchView?.setOnCloseListener {
                        if (!searchView.isIconified) {
                            searchView.isIconified = true
                        }
                        item.collapseActionView()
                    }
                }
            }
        }

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

    override fun displayCharacters(characters: MutableList<Character>) {
        adapter = MarvelCharactersAdapter(characters,this)
        charactersList.adapter = adapter
        charactersList.layoutManager = LinearLayoutManager(this)
        noNetwork.visibility = View.GONE
        fetchingProgress.visibility = View.GONE
        charactersList.visibility = View.VISIBLE
    }

    override fun updateCharacterList() {
        adapter?.updateData()
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
