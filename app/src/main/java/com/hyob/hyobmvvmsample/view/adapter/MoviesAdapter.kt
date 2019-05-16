package com.hyob.hyobmvvmsample.view.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.hyob.hyobmvvmsample.base.BaseHolder
import com.hyob.hyobmvvmsample.model.domain.Movie
import com.hyob.hyobmvvmsample.view.holder.MovieHolder

class MoviesAdapter(val delegate: Delegate) : PagedListAdapter<Movie, BaseHolder<Movie>>(COMPARATOR) {

    interface Delegate : MovieHolder.Delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<Movie> =
        when (viewType) {
            MovieHolder.id() -> MovieHolder.create(parent, delegate)
            else -> throw IllegalAccessException("cant find viewType")
        }

    override fun onBindViewHolder(holder: BaseHolder<Movie>, position: Int) {
        when (holder) {
            is MovieHolder -> holder.bind(getItem(position))
        }
    }

    override fun getItemViewType(position: Int): Int = MovieHolder.id()

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem
        }
    }

}