package com.hyob.hyobmvvmsample.paging

import androidx.paging.PagedList

object PagingConfigs {

    fun getMovieListConfig() =
        PagedList.Config.Builder()
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .setPrefetchDistance(3)
            .setEnablePlaceholders(true)
            .build()


}