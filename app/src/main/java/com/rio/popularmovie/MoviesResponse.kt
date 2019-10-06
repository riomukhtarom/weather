package com.rio.popularmovie

import com.google.gson.annotations.SerializedName

class MoviesResponse {
    @SerializedName("results")
    var listMovie: List<Movie>? = null
}