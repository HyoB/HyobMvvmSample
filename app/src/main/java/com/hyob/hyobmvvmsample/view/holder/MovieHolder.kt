package com.hyob.hyobmvvmsample.view.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hyob.hyobmvvmsample.R
import com.hyob.hyobmvvmsample.base.BaseHolder
import com.hyob.hyobmvvmsample.model.domain.Movie
import kotlinx.android.synthetic.main.holder_movie.view.*

class MovieHolder(itemView: View) : BaseHolder<Movie>(itemView) {

    override fun bind(item: Movie) : Unit = with(itemView){
        item.run {
            Glide.with(context)
                .load(cover)
                .into(imageMovieCover)
            textMovieTitle.text = title
            ratingMovie.rating = rating.toFloat()
            textYear.text = year
            textDirector.text = director
            textStarring.text = starring
        }
    }

    companion object {

        fun id() = R.layout.holder_movie

        fun new(viewGroup: ViewGroup) = with(viewGroup){
            MovieHolder(LayoutInflater.from(context).inflate(R.layout.holder_movie, this, false))
        }

    }
}