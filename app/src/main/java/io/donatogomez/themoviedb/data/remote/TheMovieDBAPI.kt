package io.donatogomez.themoviedb.data.remote

import io.donatogomez.themoviedb.model.ResultsResponse
import io.donatogomez.themoviedb.model.network.MovieNetwork
import io.donatogomez.themoviedb.model.network.SerieNetwork
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBAPI {
    @GET("/3/movie/popular")
    suspend fun getTheMovieDBPopularMovies(): ResultsResponse<MovieNetwork>

    @GET("/3/tv/popular")
    suspend fun getTheMovieDBPopularSeries(): ResultsResponse<SerieNetwork>

    //@GET("/3/movie/{movie_id}")
    //suspend fun getTheMovieDBMovieDetails(@Path("movie_id") id: Int): ResultsResponse<MovieNetwork>
    @GET("/3/movie/{movie_id}")
    suspend fun getTheMovieDBMovieDetails(@Path("movie_id") id: Int): MovieNetwork
}