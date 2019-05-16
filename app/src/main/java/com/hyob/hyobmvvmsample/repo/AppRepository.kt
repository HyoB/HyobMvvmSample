package com.hyob.hyobmvvmsample.repo

import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.hyob.hyobmvvmsample.model.domain.Movie
import com.hyob.hyobmvvmsample.paging.MoviePagingSource
import com.hyob.hyobmvvmsample.paging.PagingConfigs
import io.reactivex.Observable

class AppRepository {

    fun getMovieList(keyword: String): Observable<PagedList<Movie>> {
        val builder = RxPagedListBuilder<Int, Movie>(object : DataSource.Factory<Int, Movie>() {
            override fun create(): DataSource<Int, Movie> {
                return MoviePagingSource(keyword)
            }
        }, PagingConfigs.getMovieListConfig())

        return builder.buildObservable()
    }


}