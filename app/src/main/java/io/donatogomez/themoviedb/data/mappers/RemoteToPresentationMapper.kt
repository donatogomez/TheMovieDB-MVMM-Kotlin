package io.donatogomez.themoviedb.data.mappers

import io.donatogomez.themoviedb.model.network.MovieNetwork
import io.donatogomez.themoviedb.model.presentation.MoviePresentation
import javax.inject.Inject

class RemoteToPresentationMapper @Inject constructor() {

    fun mapToPresentationMovie(movieNetwork: MovieNetwork): MoviePresentation {
        return MoviePresentation(
            id = movieNetwork.id,
            title = movieNetwork.title,
            posterPath = movieNetwork.posterPath,
            voteCount = movieNetwork.voteCount
        )
    }

}