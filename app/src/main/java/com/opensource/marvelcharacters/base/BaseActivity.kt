package com.opensource.marvelcharacters.base

import android.view.MenuItem
import com.opensource.marvelcharacters.domain.IAnalytics
import com.opensource.marvelcharacters.framework.Navigator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

open class BaseActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var analytics: IAnalytics

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}