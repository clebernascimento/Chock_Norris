package com.example.desafiopulsus.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiopulsus.R
import com.example.desafiopulsus.data.api.ApiHelper
import com.example.desafiopulsus.data.api.RetrofitBuilder
import com.example.desafiopulsus.data.model.Joke
import com.example.desafiopulsus.data.model.Jokes
import com.example.desafiopulsus.databinding.ActivityMainBinding
import com.example.desafiopulsus.ui.main.adapter.MainAdapter
import com.example.desafiopulsus.ui.main.viewModel.MainViewModel
import com.example.desafiopulsus.ui.main.viewModel.base.ViewModelFactory
import com.example.desafiopulsus.utils.Status
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        setupUI()
        setupObservers()
        updaterJoke()
    }

    private fun updaterJoke() {
        btJoke.setOnClickListener(View.OnClickListener { setupObservers() })
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getJokes().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { joke ->
                            retrieveList(joke)
                        }
                    }
                    Status.ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, "Erro ao listar ", Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(joke: Joke) {
        adapter.apply {
            addJokes(joke)
            notifyDataSetChanged()
        }
    }
}