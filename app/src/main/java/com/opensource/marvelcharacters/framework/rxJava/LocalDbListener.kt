package com.opensource.marvelcharacters.framework.rxJava

import io.reactivex.observers.DisposableCompletableObserver

abstract class LocalDbListener: DisposableCompletableObserver() {
    override fun onComplete() {}
}