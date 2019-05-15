package com.hyob.hyobmvvmsample.repo

import android.util.Log
import com.hyob.hyobmvvmsample.model.mapper.MovieMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AppRepository {

    fun getMovieList(query: String) =
        AppService.getAppApi().getMovies(query)
            .subscribeOn(Schedulers.io())
            .map { it.movies.map { MovieMapper().mapToEntity(it) } }
            .observeOn(AndroidSchedulers.mainThread())


}