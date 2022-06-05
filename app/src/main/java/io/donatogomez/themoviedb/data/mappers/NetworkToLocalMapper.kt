package io.donatogomez.themoviedb.data.mappers


import io.donatogomez.themoviedb.model.local.MovieLocal
import io.donatogomez.themoviedb.model.local.SerieLocal
import io.donatogomez.themoviedb.model.network.MovieNetwork
import io.donatogomez.themoviedb.model.network.SerieNetwork
import javax.inject.Inject

class NetworkToLocalMapper @Inject constructor() {

    fun mapToLocalMovie(movieNetwork: MovieNetwork): MovieLocal {
        return MovieLocal(
            id = movieNetwork.id,
            title = movieNetwork.title,
            popularity = movieNetwork.popularity,
            posterPath = movieNetwork.posterPath,
            voteCount = movieNetwork.voteCount
        )
    }

    fun mapToLocalSerie(serieNetwork: SerieNetwork): SerieLocal {
        return SerieLocal(
            uid = null,
            name = serieNetwork.name,
            popularity = serieNetwork.popularity,
            posterPath = serieNetwork.posterPath,
            voteCount = serieNetwork.voteCount
        )
    }

}