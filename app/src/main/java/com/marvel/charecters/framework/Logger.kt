package com.marvel.charecters.framework

import com.marvel.charecters.domain.ILogger
import timber.log.Timber
import javax.inject.Inject

class Logger @Inject constructor() : ILogger {

    override fun d(t: Throwable) {
        Timber.d(t)
    }

    override fun d(msg: String) {
        Timber.d(msg)
    }

    override fun e(t: Throwable) {
        Timber.e(t)
    }

    override fun e(msg: String) {
        Timber.e(msg)
    }

}