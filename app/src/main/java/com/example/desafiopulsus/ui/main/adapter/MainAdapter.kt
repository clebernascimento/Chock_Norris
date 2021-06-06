package com.example.desafiopulsus.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafiopulsus.R
import com.example.desafiopulsus.data.model.Joke
import com.example.desafiopulsus.data.model.Jokes
import kotlinx.android.synthetic.main.item_jokes.view.*

class MainAdapter(private val jokes: ArrayList<Joke>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(jokes: Joke) {
            itemView.apply {
                tvUrlJokes.text = jokes.url
                tvValueJokes.text = jokes.value
                Glide.with(imgJokes.context)
                    .load(jokes.icon_url)
                    .into(imgJokes)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_jokes, parent, false)
        )

    override fun getItemCount(): Int = jokes.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(jokes[position])
    }

    fun addJokes(joke: Joke) {
        this.jokes.apply {
            clear()
            add(joke)
        }
    }
}
