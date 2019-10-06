package com.rio.popularmovie

interface PopularMovieCallback {
    fun onFailure(errorMessage: String)
    fun onSuccess(response: MoviesResponse)
}