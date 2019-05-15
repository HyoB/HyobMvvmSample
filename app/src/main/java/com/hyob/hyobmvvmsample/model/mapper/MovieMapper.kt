package com.hyob.hyobmvvmsample.model.mapper

import com.hyob.hyobmvvmsample.base.BaseMapper
import com.hyob.hyobmvvmsample.model.domain.Movie
import com.hyob.hyobmvvmsample.model.vo.MovieVo

class MovieMapper: BaseMapper<MovieVo, Movie> {

    override fun mapToEntity(value: MovieVo): Movie =
        value.run {
            Movie(
                title = title,
                cover = image,
                rating = userRating?.toFloat()?:0F,
                year = "2000",
                director = director,
                starring = actor,
                link = link
            )
        }

}