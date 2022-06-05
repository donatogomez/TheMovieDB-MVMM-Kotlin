package io.donatogomez.themoviedb.data.remote

import io.donatogomez.themoviedb.model.network.MovieNetwork
import io.donatogomez.themoviedb.model.network.SerieNetwork

interface RemoteDataSourceInterface {
    suspend fun getRemotePopularMovies(): List<MovieNetwork>
    suspend fun getRemotePopularSeries(): List<SerieNetwork>
    //suspend fun getRemoteMovieDetails(id: Int): List<MovieNetwork>
    suspend fun getRemoteMovieDetails(id: Int): MovieNetwork
}