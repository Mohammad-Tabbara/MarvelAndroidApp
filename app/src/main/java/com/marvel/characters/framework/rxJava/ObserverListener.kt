package com.marvel.characters.framework.rxJava

import io.reactivex.observers.DisposableObserver

abstract class ObserverListener<T>: DisposableObserver<T>() {
    override fun onComplete() {}
}