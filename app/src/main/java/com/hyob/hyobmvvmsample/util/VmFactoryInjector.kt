@file:Suppress("UNCHECKED_CAST")

package com.hyob.hyobmvvmsample.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.hyob.hyobmvvmsample.repo.AppRepository
import com.hyob.hyobmvvmsample.view.activity.MoviesActivity
import com.hyob.hyobmvvmsample.vm.MoviesViewModel

object VmFactoryInjector {

    private fun getMoviesFactory() =
        object : ViewModelProvider.NewInstanceFactory() {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MoviesViewModel(AppRepository()) as T
            }
        }

    fun getMoviesVm(activity: MoviesActivity) =
            ViewModelProviders.of(activity, getMoviesFactory()).get(MoviesViewModel::class.java)


}