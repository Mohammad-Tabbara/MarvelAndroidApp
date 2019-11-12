package com.marvel.characters.framework.rxJava

import io.reactivex.observers.DisposableSingleObserver

abstract class SingleListener<T>: DisposableSingleObserver<T>()