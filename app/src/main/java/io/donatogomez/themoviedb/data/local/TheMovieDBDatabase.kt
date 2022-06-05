package io.donatogomez.themoviedb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.donatogomez.themoviedb.model.local.MovieLocal
import io.donatogomez.themoviedb.model.local.SerieLocal

@Database(entities = [MovieLocal::class, SerieLocal::class], version = 4)
abstract class TheMovieDBDatabase : RoomDatabase() {
    abstract fun theMovieDBDao(): TheMovieDBDao
}