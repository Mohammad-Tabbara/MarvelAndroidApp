package com.marvel.charecters.domain

import com.marvel.charecters.framework.api.Wrapper
import io.reactivex.SingleObserver

interface IContentManager{
    fun getMarvellCharectersByPage(page: Int, listener: SingleObserver<Wrapper>)
}