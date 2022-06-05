package io.donatogomez.themoviedb.model.network

import com.squareup.moshi.Json

data class MovieNetwork(
    @Json(name = "id") val id: Int = 0,
    @Json(name = "title") val title: String = "",
    @Json(name = "popularity") val popularity: Double = 0.0,
    @Json(name = "poster_path") val posterPath: String = "",
    @Json(name = "genre_ids") val genreIds: List<Int> = listOf(),
    @Json(name = "vote_count") val voteCount: Int = 0
)