package com.hyob.hyobmvvmsample.view.holder

import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import com.hyob.hyobmvvmsample.R
import com.hyob.hyobmvvmsample.base.BaseHolder
import com.hyob.hyobmvvmsample.model.domain.Movie
import kotlinx.android.synthetic.main.holder_movie.view.*
import java.util.logging.Logger

class MovieHolder(itemView: View, val delegate: Delegate) : BaseHolder<Movie>(itemView) {

    interface Delegate {
        fun onMovieClick(link: String)
    }

    override fun bind(item: Movie?): Unit = with(itemView) {
        item?.run {
            Glide.with(context)
                .load(cover)
                .into(imageMovieCover)
            textMovieTitle.text = Html.fromHtml(title)
            ratingMovie.rating = rating
            textYear.text = year
            textDirector.text = director
            textStarring.text = starring
            this@with.setOnClickListener {
                delegate.onMovieClick(link)
            }
        }
        Log.d("MovieHolder::item", item.toString())
    }

    companion object {

        fun id() = R.layout.holder_movie

        fun create(viewGroup: ViewGroup, delegate: Delegate): MovieHolder = with(viewGroup) {
            MovieHolder(LayoutInflater.from(context).inflate(R.layout.holder_movie, this, false), delegate)
        }

    }
}