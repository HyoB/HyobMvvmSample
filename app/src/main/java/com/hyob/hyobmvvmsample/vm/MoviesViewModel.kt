package com.hyob.hyobmvvmsample.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.hyob.hyobmvvmsample.model.domain.Movie
import com.hyob.hyobmvvmsample.model.mapper.MovieMapper
import com.hyob.hyobmvvmsample.repo.AppRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers

class MoviesViewModel(val appRepository: AppRepository) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val moviesLiveData = MutableLiveData<PagedList<Movie>?>()

    fun search(keyword: String) {
        disposables += appRepository.getMovieList(keyword)
            .subscribeOn(Schedulers.io())
            .subscribe({
                moviesLiveData.value = it
            }, {
                Log.d("MoviesViewModel", "${it.message}")
            })

    }

    fun getMovies() = moviesLiveData

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

}