package com.opensource.marvelcharacters.framework.rxJava

import io.reactivex.observers.DisposableObserver

abstract class ObserverListener<T>: DisposableObserver<T>() {
    override fun onComplete() {}
}