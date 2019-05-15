package com.hyob.hyobmvvmsample.repo

import com.hyob.hyobmvvmsample.model.vo.MovieSearchVo
import com.hyob.hyobmvvmsample.model.vo.MovieVo
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApi {

//    @GET("/search/movie.json")
//    fun getMovies(query: String): Single<List<Movie>>

    @GET("/search/movie.json")
    fun getMovies(@Query("query") query: String): Single<MovieSearchVo>

}