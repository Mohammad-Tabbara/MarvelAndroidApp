package com.opensource.marvelcharacters.presentation._common.custom

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PaginationListener(private val loadMore: LoadMore) : RecyclerView.OnScrollListener() {

    val visibleThreshold: Int = 5

    var isLoading : Boolean = false
    set(value) {
        field = value
    }
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val llm = recyclerView.layoutManager
        if(llm is LinearLayoutManager) {
            val lastVisibleItem = llm.findLastVisibleItemPosition()
            val itemCount = llm.itemCount
            if (!isLoading && itemCount <= lastVisibleItem + visibleThreshold) {
                isLoading = true
                loadMore.loadMore(itemCount)
            }
        }

    }
    interface LoadMore{
        fun loadMore(offset:Int)
    }
}