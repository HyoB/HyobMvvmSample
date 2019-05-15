package com.hyob.hyobmvvmsample.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hyob.hyobmvvmsample.base.BaseHolder
import com.hyob.hyobmvvmsample.model.domain.Movie
import com.hyob.hyobmvvmsample.view.holder.MovieHolder

class MoviesAdapter: ListAdapter<Movie, BaseHolder<Movie>>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<Movie> =
        MovieHolder.new(parent)


    override fun onBindViewHolder(holder: BaseHolder<Movie>, position: Int) {
        holder.bind(super.getItem(position))
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean = false

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean = false
        }
    }

}