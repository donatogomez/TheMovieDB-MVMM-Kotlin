package io.donatogomez.themoviedb.data.repository

import io.donatogomez.themoviedb.model.presentation.MoviePresentation
import io.donatogomez.themoviedb.model.presentation.SeriePresentation


interface RepositoryInterface {
    suspend fun getRepositoryPopularMovies(): List<MoviePresentation>
    suspend fun getRepositoryPopularSeries(): List<SeriePresentation>
    //suspend fun getRepositoryMovieDetailsById(id: Int): List<MoviePresentation>
    suspend fun getRepositoryMovieDetailsById(id: Int): MoviePresentation
}