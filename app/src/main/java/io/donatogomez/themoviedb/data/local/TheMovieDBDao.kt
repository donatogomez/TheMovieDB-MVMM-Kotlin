package io.donatogomez.themoviedb.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.donatogomez.themoviedb.model.local.MovieLocal
import io.donatogomez.themoviedb.model.local.SerieLocal

@Dao
interface TheMovieDBDao { 

    // -------- MOVIES -------
    
    @Query("SELECT * FROM movies")
    fun getAllMovies(): List<MovieLocal>

    @Query("SELECT * FROM movies WHERE id = :id")
    fun getMovieById(id: Int): MovieLocal

    @Insert
    fun insertMovie(movieLocal: MovieLocal)

    @Delete
    fun deleteMovie(movieLocal: MovieLocal)

    @Query("UPDATE movies SET isFavorite = :favorite WHERE id = :id")
    fun addFavoriteMovies(id: Long, favorite: Boolean)

    @Query("DELETE FROM movies WHERE id = :id")
    fun deleteMovieById(id: Long)


    // -------- SERIES -------
    
    @Query("SELECT * FROM series")
    fun getAllSeries(): List<SerieLocal>

    @Insert
    fun insertSerie(serieLocal: SerieLocal)

    @Delete
    fun deleteSerie(serieLocal: SerieLocal)

}
