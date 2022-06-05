package io.donatogomez.themoviedb.model

import com.squareup.moshi.Json
import io.donatogomez.themoviedb.model.network.MovieNetwork

data class ResultsResponse<T> (
    @Json(name = "total_results") val totalResults: Int?,
    @Json(name = "results") val results: List<T> = emptyList()
)

