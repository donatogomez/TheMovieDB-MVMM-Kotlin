package io.donatogomez.themoviedb.data.repository

import android.util.Log
import io.donatogomez.themoviedb.data.mappers.LocalToPresentationMapper
import io.donatogomez.themoviedb.data.mappers.NetworkToLocalMapper
import io.donatogomez.themoviedb.data.local.LocalDataSource
import io.donatogomez.themoviedb.data.mappers.RemoteToPresentationMapper
import io.donatogomez.themoviedb.data.remote.RemoteDataSource
import io.donatogomez.themoviedb.model.presentation.MoviePresentation
import io.donatogomez.themoviedb.model.presentation.SeriePresentation
import javax.inject.Inject

// ViewModel -> Repository -> Sources
class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource,
    private val networkToLocalMapper: NetworkToLocalMapper,
    private val localToPresentationMapper: LocalToPresentationMapper,
    private val remoteToPresentationMapper: RemoteToPresentationMapper
) : RepositoryInterface {

    override suspend fun getRepositoryPopularMovies(): List<MoviePresentation> {
        /*val localMovies = local.getAllMovies()
        Log.d("REPOSITORY", "Tamaño inicial: ${localMovies.size}")

        if (localMovies.isEmpty()) {
            Log.d("REPOSITORY", "Local vacio, pido a remote")
            val remoteMovies = remote.getRemotePopularMovies()

            Log.d("REPOSITORY", "Tamaño remote: ${remoteMovies.size}")

            remoteMovies.forEach {
                Log.d("REPOSITORY", "Insertando local: $it")
                local.insertMovie(networkToLocalMapper.mapToLocalMovie(it))
            }
        }

        val newLocalMovies = local.getAllMovies()
        Log.d("REPOSITORY", "Tamaño final en local: ${newLocalMovies.size}")

        return newLocalMovies.map { localToPresentationMapper.mapToPresentationMovie(it) }*/
        Log.d("Popular Movies", remote.getRemotePopularMovies().toString())

        val popularMovies = remote.getRemotePopularMovies()
        return popularMovies.map { remoteToPresentationMapper.mapToPresentationMovie(it) }
    }

    override suspend fun getRepositoryPopularSeries(): List<SeriePresentation> {
        val localSeries = local.getAllSeries()
        Log.d("REPOSITORY", "Tamaño inicial de series: ${localSeries.size}")

        if (localSeries.isEmpty()) {
            Log.d("REPOSITORY", "Local vacio, pido a remote")
            val remoteSeries = remote.getRemotePopularSeries()

            Log.d("REPOSITORY", "Tamaño remote: ${remoteSeries.size}")

            remoteSeries.forEach {
                Log.d("REPOSITORY", "Insertando local: $it")
                local.insertSerie(networkToLocalMapper.mapToLocalSerie(it))
            }
        }

        val newLocalSerie = local.getAllSeries()
        Log.d("REPOSITORY", "Tamaño final en local: ${newLocalSerie.size}")

        return newLocalSerie.map { localToPresentationMapper.mapToPresentationSerie(it) }
    }

    override suspend fun getRepositoryMovieDetailsById(id: Int): MoviePresentation {
        val remoteMovies = remote.getRemoteMovieDetails(id)
        return remoteToPresentationMapper.mapToPresentationMovie(remoteMovies)
    }

   /* override suspend fun getRepositoryMovieDetailsById(id: Int): List<MoviePresentation> {
        val remoteMovies = local.getAllSeries()
        Log.d("REPOSITORY", "Tamaño inicial de series: ${localSeries.size}")

        if (localSeries.isEmpty()) {
            Log.d("REPOSITORY", "Local vacio, pido a remote")
            val remoteSeries = remote.getRemotePopularSeries()

            Log.d("REPOSITORY", "Tamaño remote: ${remoteSeries.size}")

            remoteSeries.forEach {
                Log.d("REPOSITORY", "Insertando local: $it")
                local.insertSerie(networkToLocalMapper.mapToLocalSerie(it))
            }
        }

        val newLocalSerie = local.getAllSeries()
        Log.d("REPOSITORY", "Tamaño final en local: ${newLocalSerie.size}")

        return newLocalSerie.map { localToPresentationMapper.mapToPresentationSerie(it) }
    }*/

}

