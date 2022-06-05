package io.donatogomez.themoviedb.model.network

import com.squareup.moshi.Json

data class SerieNetwork(
    @Json(name = "name") val name: String = "",
    @Json(name = "popularity") val popularity: Double = 0.0,
    @Json(name = "poster_path") val posterPath: String = "",
    @Json(name = "vote_count") val voteCount: Int = 0
)
