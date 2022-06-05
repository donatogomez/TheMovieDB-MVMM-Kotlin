package io.donatogomez.themoviedb.data.remote

import io.donatogomez.themoviedb.model.network.MovieNetwork
import io.donatogomez.themoviedb.model.network.SerieNetwork
import javax.inject.Inject


class RemoteDataSource @Inject constructor(
    private val api: TheMovieDBAPI
) : RemoteDataSourceInterface {

    override suspend fun getRemotePopularMovies(): List<MovieNetwork> {
        val response = api.getTheMovieDBPopularMovies()
        return response.results
    }

    override suspend fun getRemotePopularSeries(): List<SerieNetwork> {
        val response = api.getTheMovieDBPopularSeries()
        return response.results
    }

    /**override suspend fun getRemoteMovieDetails(id: Int): List<MovieNetwork> {
    val response = api.getTheMovieDBMovieDetails(id)
    return response.results
    }*/

    override suspend fun getRemoteMovieDetails(id: Int): MovieNetwork {
        return api.getTheMovieDBMovieDetails(id)
    }
}
