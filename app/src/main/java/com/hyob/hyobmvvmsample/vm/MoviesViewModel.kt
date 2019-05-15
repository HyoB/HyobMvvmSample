package com.hyob.hyobmvvmsample.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hyob.hyobmvvmsample.model.domain.Movie
import com.hyob.hyobmvvmsample.repo.AppRepository
import com.hyob.hyobmvvmsample.repo.AppService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers

class MoviesViewModel(val appRepo: AppRepository): ViewModel() {

    private val disposables = CompositeDisposable()
    private val moviesLiveData = MutableLiveData<List<Movie>?>()

    fun search (keyword: String) {
        disposables += appRepo.getMovieList(keyword)
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