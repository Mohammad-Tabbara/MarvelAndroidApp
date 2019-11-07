package com.marvel.characters.di

import com.marvel.characters.presentation.character_details.CharacterDetailsActivity
import com.marvel.characters.presentation.character_details.CharacterDetailsModule
import com.marvel.characters.presentation.webview.WebViewActivity
import com.marvel.characters.presentation.webview.WebViewModule
import com.marvel.characters.presentation.main.MainActivity
import com.marvel.characters.presentation.main.MainActivityModule
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
}