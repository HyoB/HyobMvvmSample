package com.hyob.hyobmvvmsample.repo

import com.hyob.hyobmvvmsample.model.vo.MovieSearchVo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApi {

    @GET("/v1/search/movie.json")
    fun getMovies(
        @Query("query") query: String,
        @Query("start") start: Int,
        @Query("display") display: Int? = 10
    ): Single<MovieSearchVo>

}