package com.rio.popularmovie

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("movie/popular")
    fun getPopularMovie(@Query("api_key") apiKey: String) : Call<MoviesResponse>
}