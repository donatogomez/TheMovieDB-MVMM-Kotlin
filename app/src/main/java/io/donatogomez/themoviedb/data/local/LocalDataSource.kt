package io.donatogomez.themoviedb.data.local


import io.donatogomez.themoviedb.model.local.MovieLocal
import io.donatogomez.themoviedb.model.local.SerieLocal
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val theMovieDBDao: TheMovieDBDao,
    private val preferencesManager: PreferencesManager
) {

    //------- MOVIES -------

    fun getAllMovies(): List<MovieLocal> {
        return theMovieDBDao.getAllMovies()
    }

    fun insertMovie(movieLocal: MovieLocal) {
        theMovieDBDao.insertMovie(movieLocal)
    }

    fun getAllMovieDetails(): List<MovieLocal> {
        return theMovieDBDao.getAllMovies()
    }

    fun deleteMovie(movieLocal: MovieLocal) {
        theMovieDBDao.deleteMovie(movieLocal)
    }

    fun getNumberOfAppOpened(): Int {
        return preferencesManager.getNumberOfAppOpened()
    }

    fun increaseNumberOfAppOpened() {
        val oldValue = preferencesManager.getNumberOfAppOpened()
        preferencesManager.setNumberOfAppOpened(oldValue + 1)
    }

    //------- SERIES -------

    fun getAllSeries(): List<SerieLocal> {
        return theMovieDBDao.getAllSeries()
    }

    fun insertSerie(serieLocal: SerieLocal) {
        theMovieDBDao.insertSerie(serieLocal)
    }

    fun deleteSerie(serieLocal: SerieLocal) {
        theMovieDBDao.deleteSerie(serieLocal)
    }
}
