package com.marvel.charecters.presentation.character_details

import com.marvel.charecters.domain.IContentManager
import com.marvel.charecters.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class CharacterDetailsModule {

    @Binds
    abstract fun bindView(mainActivity: CharacterDetailsActivity): CharacterDetailsContract.View

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun bindPresenter(view: CharacterDetailsContract.View, logger: ILogger): CharacterDetailsContract.Presenter = CharacterDetailsPresenterImpl(view,logger)

    }

}