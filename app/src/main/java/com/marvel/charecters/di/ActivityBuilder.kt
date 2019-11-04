package com.marvel.charecters.di

import com.marvel.charecters.presentation.character_details.CharacterDetailsActivity
import com.marvel.charecters.presentation.character_details.CharacterDetailsModule
import com.marvel.charecters.presentation.webview.WebViewActivity
import com.marvel.charecters.presentation.webview.WebViewModule
import com.marvel.charecters.presentation.main.MainActivity
import com.marvel.charecters.presentation.main.MainActivityModule
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