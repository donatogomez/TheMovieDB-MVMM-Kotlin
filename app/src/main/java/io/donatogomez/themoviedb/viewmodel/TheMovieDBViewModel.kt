package io.donatogomez.themoviedb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.donatogomez.themoviedb.data.repository.Repository
import io.donatogomez.themoviedb.model.presentation.MoviePresentation
import io.donatogomez.themoviedb.model.presentation.SeriePresentation
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class TheMovieDBViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {


    val data: MutableLiveData<List<MoviePresentation>> = MutableLiveData()
    val data2: MutableLiveData<List<SeriePresentation>> = MutableLiveData()
/*
    val data1: MutableLiveData<List<MovieNetwork>> = MutableLiveData()

    val numberOfAppOpened: MutableLiveData<Int> = MutableLiveData()*/

    fun getViewModelPopularMovies() {
        viewModelScope.launch {
            val movies = withContext(Dispatchers.IO) {
                repository.getRepositoryPopularMovies()
            }
            data.postValue(movies)
        }
    }

    fun getViewModelPopularSeries() {
        viewModelScope.launch {
            val series = withContext(Dispatchers.IO) {
                repository.getRepositoryPopularSeries()
            }
            data2.postValue(series)
        }
    }

/*    private fun getNumberOfAppOpened() {
        numberOfAppOpened.postValue(repository.getNumberOfAppOpened())
    }

    fun increaseNumberOfAppOpened() {
        repository.increaseNumberOfAppOpened()
        getNumberOfAppOpened()
    }

    fun getMoviesReactivo() {
        data1.postValue(
            listOf(
                "Batman 1",
                "Batman 2",
                "Batman 3"

            ).map { MovieNetwork(it) })
    }

    fun updateSoloStarWars() {
        data1.postValue(
            listOf(
                "Star Wars 1",
                "Star Wars 2",
                "Star Wars 3",
                "Star Wars 4",
                "Star Wars 5",
                "Star Wars 6"
            ).map { MovieNetwork(it) })
    }

    fun threadBloqueante() {
*//*        val thread = Thread(
            Runnable {
                Log.d("THREAD BLOQUEANTE", "START")
                Thread.sleep(5000)
                Log.d("THREAD BLOQUEANTE", "END")
            }
        )*//*
        val handler = android.os.Handler(Looper.getMainLooper()).post(
            Runnable {
                Log.d("THREAD BLOQUEANTE", "START")
                Thread.sleep(5000)
                Log.d("THREAD BLOQUEANTE", "END")
            }
        )
        //thread.run()
    }

    fun getMoviesConCorrutinas() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(5000)
            data1.postValue(
                listOf(
                    "Star Wars 1",
                    "Star Wars 2",
                    "Star Wars 3",
                    "Star Wars 4",
                    "Star Wars 5",
                    "Star Wars 6"
                ).map { MovieNetwork(it) })
        }
    }

    fun getMoviesConCorrutinasResult() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getListMovies(0, 10)
            val result2 = getListMovies(10, 10)

            val resultWithContext = withContext(Dispatchers.IO) {
                delay(1000)
                "HOLA"
            }

            val resultLaunch = launch {

            }
            resultLaunch.cancel()

            val resultAsync = async {
                delay(3000)
                "HOLA"
            }

            resultAsync.await()

            Log.d("CORRUTINAS", resultWithContext)
            Log.d("CORRUTINAS", resultAsync.await())
            Log.d("CORRUTINAS", resultLaunch.toString())
        }
    }

    private suspend fun getListMovies(start: Int, size: Int): List<MovieNetwork> {
        val movies = mutableListOf<MovieNetwork>()
        for (i in start..(start + size)) {
            movies.add(MovieNetwork("Title $i"))
        }
        return movies
    }


    fun getMoviesImperativo(): List<MovieNetwork> {
        return listOf(
            "Star Wars",
            "El Hobbit",
            "Piratas del Caribe",
            "Batman",
            "Superman",
            "Marvel",
            "Star Wars",
            "El Hobbit",
            "Piratas del Caribe",
            "Batman",
            "Superman",
            "Marvel",
            "Star Wars",
            "El Hobbit",
            "Piratas del Caribe",
            "Batman",
            "Superman",
            "Marvel"
        ).map { MovieNetwork(it) }
    }

    fun deleteLocalDatabase() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.deleteMovies()
            }
            getViewModelPopularMovies()
        }
    }

    fun deleteFirstMovie() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.deleteMovie(data.value?.first())
            }
            getViewModelPopularMovies()
        }
    }*/
}