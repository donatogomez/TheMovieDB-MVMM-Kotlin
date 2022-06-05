package io.donatogomez.themoviedb.model.presentation

data class MoviePresentation(
    val id: Int = 0,
    val title: String = "",
    val posterPath: String = "",
    val voteCount: Int = 0
)