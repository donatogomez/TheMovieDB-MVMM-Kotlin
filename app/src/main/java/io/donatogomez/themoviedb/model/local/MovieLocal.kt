package io.donatogomez.themoviedb.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieLocal(
    //@PrimaryKey(autoGenerate = true)  @ColumnInfo(name = "id") val id: Int?,
    @PrimaryKey @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "popularity")  val popularity: Double = 0.0,
    @ColumnInfo(name = "poster_path") val posterPath: String = "",
    @ColumnInfo(name = "vote_count") val voteCount: Int = 0,
    @ColumnInfo(name = "isFavorite") var isFavorite: Boolean? = false
)