package com.opensource.marvelcharacters.framework.rxJava

import io.reactivex.observers.DisposableSingleObserver

abstract class ApiListener<T>: DisposableSingleObserver<T>()