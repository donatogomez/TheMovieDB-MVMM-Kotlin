package io.donatogomez.themoviedb.data.mappers


import io.donatogomez.themoviedb.model.local.MovieLocal
import io.donatogomez.themoviedb.model.local.SerieLocal
import io.donatogomez.themoviedb.model.presentation.MoviePresentation
import io.donatogomez.themoviedb.model.presentation.SeriePresentation
import javax.inject.Inject

class LocalToPresentationMapper @Inject constructor() {
    fun mapToPresentationMovie(movieLocal: MovieLocal): MoviePresentation {
        return MoviePresentation(
            id = movieLocal.id,
            title = movieLocal.title,
            posterPath = movieLocal.posterPath,
            voteCount = movieLocal.voteCount
        )
    }

    fun mapToPresentationSerie(serieLocal: SerieLocal): SeriePresentation {
        return SeriePresentation(
            name = serieLocal.name,
            posterPath = serieLocal.posterPath,
            voteCount = serieLocal.voteCount
        )
    }
}