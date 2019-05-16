@file:Suppress("UNCHECKED_CAST")

package com.hyob.hyobmvvmsample.vm

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.hyob.hyobmvvmsample.repo.AppRepository
import com.hyob.hyobmvvmsample.view.activity.MoviesActivity

object MoviesViewModelFactory {

    private fun getMoviesFactory() =
        object : ViewModelProvider.NewInstanceFactory() {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MoviesViewModel(AppRepository()) as T
            }
        }

    fun getMoviesVm(activity: AppCompatActivity) =
            ViewModelProviders.of(activity, getMoviesFactory()).get(MoviesViewModel::class.java)


}