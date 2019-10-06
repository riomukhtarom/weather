package com.rio.popularmovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.WeatherViewHolder>() {

    private val mListData = ArrayList<Movie>()

    fun setData(items: ArrayList<Movie>){
        mListData.clear()
        mListData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return WeatherViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return mListData.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(mListData[position])
    }

    inner class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movie) {
            with(itemView){
                text_title.text = movie.title
                text_desc.text = movie.overview
            }
        }
    }
}