package com.rio.popularmovie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    private val list = MutableLiveData<ArrayList<Movie>>()

    internal fun setMovie(){

        val listTemp = ArrayList<Movie>()
        NetworkRepository.getListPopularMovie(object: PopularMovieCallback{
            override fun onFailure(errorMessage: String) {
                Log.i("ViewModel", errorMessage)
            }

            override fun onSuccess(response: MoviesResponse) {
                listTemp.addAll(response.listMovie!!)
                list.postValue(listTemp)
                Log.i("ViewModel", "Success")
            }

        })
    }

    internal fun getMovie() : LiveData<ArrayList<Movie>>{
        return list
    }

}