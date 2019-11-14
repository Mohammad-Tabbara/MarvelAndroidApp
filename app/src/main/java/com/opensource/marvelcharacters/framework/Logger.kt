package com.opensource.marvelcharacters.framework

import com.crashlytics.android.Crashlytics
import com.opensource.marvelcharacters.domain.ILogger
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class Logger @Inject constructor() : ILogger {

    override fun d(t: Throwable) {
        Timber.d(t)
    }

    override fun d(msg: String) {
        Timber.d(msg)
    }

    override fun e(t: Throwable) {
        Crashlytics.logException(t)
        Timber.e(t)
    }

    override fun e(msg: String) {
        Crashlytics.logException(Exception(msg))
        Timber.e(msg)
    }

}