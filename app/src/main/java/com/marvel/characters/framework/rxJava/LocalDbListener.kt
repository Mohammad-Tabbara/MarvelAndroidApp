package com.marvel.characters.framework.rxJava

import io.reactivex.observers.DisposableCompletableObserver

abstract class LocalDbListener: DisposableCompletableObserver() {
    override fun onComplete() {}
}