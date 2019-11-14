package com.opensource.marvelcharacters.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.opensource.marvelcharacters.R
import com.opensource.marvelcharacters.base.BaseActivity
import com.opensource.marvelcharacters.presentation._common.models.Character
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.no_network_connection.*
import javax.inject.Inject
import androidx.appcompat.widget.SearchView
import androidx.core.view.iterator
import com.opensource.marvelcharacters.presentation._common.adapters.MarvelCharactersAdapter


class MainActivity : BaseActivity(), MainContract.View,
    MarvelCharactersAdapter.MarvelAdapterListener {

    companion object{
        fun getInstance(context:Context):Intent = Intent(context,MainActivity::class.java)
    }

    @Inject
    lateinit var presenter: MainContract.Presenter

    var adapter : MarvelCharactersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onCreate()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
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
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.open_favorites -> {
                presenter.openFavorites()
            }
        }
        return super.onOptionsItemSelected(item)
    }



    override fun initLayout() {
        setSupportActionBar(toolbar)

        presenter.fetchCharacters()
        retryButton.setOnClickListener {
            presenter.fetchCharacters()
        }

        adapter = MarvelCharactersAdapter(
            mutableListOf(),
            this
        )
        charactersList.adapter = adapter
        charactersList.layoutManager = LinearLayoutManager(this)
    }

    override fun startFetching() {
        noNetwork.visibility = View.GONE
        fetchingProgress.visibility = View.VISIBLE
        charactersList.visibility = View.GONE
    }

    override fun displayCharacters(characters: MutableList<Character>) {
        adapter = MarvelCharactersAdapter(
            characters,
            this
        )
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

    override fun navigateToFavoriteCharactersScreen() {
        navigator.navigateToFavoriteCharacters(this,false)
    }

}
