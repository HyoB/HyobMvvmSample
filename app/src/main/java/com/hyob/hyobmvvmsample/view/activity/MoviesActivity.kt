package com.hyob.hyobmvvmsample.view.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyob.hyobmvvmsample.R
import com.hyob.hyobmvvmsample.extension.hideSoftKeyboard
import com.hyob.hyobmvvmsample.vm.MoviesViewModelFactory
import com.hyob.hyobmvvmsample.view.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MoviesActivity : AppCompatActivity(), MoviesAdapter.Delegate {

    val vm by lazy { MoviesViewModelFactory.getMoviesVm(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesAdapter = MoviesAdapter(this)

        recyclerMovies.apply {
            layoutManager = LinearLayoutManager(this@MoviesActivity)
            adapter = moviesAdapter
        }

        buttonSearch.apply {
            setOnClickListener {
                vm.search(editKeyword.text.toString())
                hideSoftKeyboard(editKeyword)
            }
        }

        editKeyword.apply {
            setOnEditorActionListener { v, actionId, _ ->
                handleKeyboardAction(v, actionId)
            }
        }

        vm.getMovies()
            .observe({ lifecycle }, {
                moviesAdapter.submitList(it)
            })
    }

    fun handleKeyboardAction(view: TextView, actionId: Int) =
        when(actionId) {
            EditorInfo.IME_ACTION_SEARCH -> {
                vm.search(view.text.toString())
                hideSoftKeyboard(view)
                true
            }
            else -> false
        }


    override fun onMovieClick(link: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }
}
