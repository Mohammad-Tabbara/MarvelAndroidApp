package com.opensource.marvelcharacters.di

import com.opensource.marvelcharacters.presentation.character_details.CharacterDetailsActivity
import com.opensource.marvelcharacters.presentation.character_details.CharacterDetailsModule
import com.opensource.marvelcharacters.presentation.favorite_characters.FavoriteCharactersActivity
import com.opensource.marvelcharacters.presentation.favorite_characters.FavoriteCharactersModule
import com.opensource.marvelcharacters.presentation.webview.WebViewActivity
import com.opensource.marvelcharacters.presentation.webview.WebViewModule
import com.opensource.marvelcharacters.presentation.main.MainActivity
import com.opensource.marvelcharacters.presentation.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [CharacterDetailsModule::class])
    abstract fun bindCharacterDetailsActivity(): CharacterDetailsActivity

    @ContributesAndroidInjector(modules = [WebViewModule::class])
    abstract fun bindWebViewActivity(): WebViewActivity

    @ContributesAndroidInjector(modules = [FavoriteCharactersModule::class])
    abstract fun bindFavoriteCharactersActivity(): FavoriteCharactersActivity
}