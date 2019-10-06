package com.rio.popularmovie

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkRepository {

    private const val BASE_URL = BuildConfig.BASE_URL
    private const val API_KEY = BuildConfig.TMDB_API_KEY

    private fun create(): Api{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(Api::class.java)
    }

    fun getListPopularMovie(callback: PopularMovieCallback){
        create().getPopularMovie(API_KEY).enqueue(object: Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.e("Network", t.message)
                callback.onFailure(t.message.toString())
            }

            override fun onResponse(call: Call<MoviesResponse>,response: Response<MoviesResponse>) {
                Log.i("Network", "Success")
                if (response.isSuccessful){
                    callback.onSuccess(response.body()!!)
                } else {
                    callback.onFailure(response.message())
                }
            }
        })
    }
}