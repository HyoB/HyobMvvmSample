package com.hyob.hyobmvvmsample.paging

import android.annotation.SuppressLint
import android.util.Log
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import androidx.paging.PositionalDataSource
import com.hyob.hyobmvvmsample.base.BaseMapper
import com.hyob.hyobmvvmsample.model.domain.Movie
import com.hyob.hyobmvvmsample.model.mapper.MovieMapper
import com.hyob.hyobmvvmsample.model.vo.MovieVo
import com.hyob.hyobmvvmsample.repo.AppService
import io.reactivex.schedulers.Schedulers
import java.util.logging.Logger

class MoviePagingSource(val query: String) : PageKeyedDataSource<Int, Movie>() {

    @SuppressLint("CheckResult")
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        AppService.getAppApi().getMovies(query, 1)
            .subscribeOn(Schedulers.io())
            .subscribe({
                val movies = it.movies.map { MovieMapper().mapToEntity(it) }
                callback.onResult(movies, null, 1 + it.display)
            }, {
                Log.d("MoviePagingSource", "loadInitial Failed")
            })
    }

    @SuppressLint("CheckResult")
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        AppService.getAppApi().getMovies(query, params.key)
            .subscribeOn(Schedulers.io())
            .subscribe({
                if(params.key <= it.total) {
                    val movies = it.movies.map { MovieMapper().mapToEntity(it) }
                    callback.onResult(movies, params.key + it.display)
                }
            }, {
                Log.d("MoviePagingSource", "loadRange Failed")
            })
    }

    @SuppressLint("CheckResult")
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
    }
}
