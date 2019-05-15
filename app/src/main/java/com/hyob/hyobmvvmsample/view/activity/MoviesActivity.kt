package com.hyob.hyobmvvmsample.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyob.hyobmvvmsample.R
import com.hyob.hyobmvvmsample.util.VmFactoryInjector
import com.hyob.hyobmvvmsample.view.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MoviesActivity : AppCompatActivity() {

    val vm by lazy { VmFactoryInjector.getMoviesVm(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesAdapter = MoviesAdapter()

        recyclerMovies.apply {
            layoutManager = LinearLayoutManager(this@MoviesActivity)
            adapter = moviesAdapter
        }

        buttonSearch.apply {
            setOnClickListener {
                vm.search(editKeyword.text.toString())
            }
        }

        vm.getMovies()
            .observe({ lifecycle }, {
                moviesAdapter.submitList(it)
            })

    }
}
