package com.marvel.charecters.base

import com.marvel.charecters.framework.Navigator
import dagger.android.DaggerActivity
import javax.inject.Inject

open class BaseActivity : DaggerActivity() {
    @Inject
    lateinit var navigator: Navigator
}