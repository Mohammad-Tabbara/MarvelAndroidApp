package com.marvel.characters.domain

import com.marvel.characters.framework.api.Wrapper
import io.reactivex.SingleObserver

interface IContentManager{
    fun getMarvellCharectersByPage(page: Int, listener: SingleObserver<Wrapper>)
}