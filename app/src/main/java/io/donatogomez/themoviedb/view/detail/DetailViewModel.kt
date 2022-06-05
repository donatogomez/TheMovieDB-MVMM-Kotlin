package io.donatogomez.themoviedb.view.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.donatogomez.themoviedb.data.repository.Repository
import io.donatogomez.themoviedb.model.presentation.MoviePresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    val data: MutableLiveData<List<MoviePresentation>> = MutableLiveData()
    val data2: MutableLiveData<MoviePresentation> = MutableLiveData()

    fun getViewModelMoviesDetails(id: Int) {
        viewModelScope.launch {
            val moviesDetails = async(Dispatchers.IO) {
                return@async repository.getRepositoryMovieDetailsById(id)
            }

            val popularSeries = async(Dispatchers.IO) {
                repository.getRepositoryPopularSeries()
            }

            val popularMovies = async(Dispatchers.IO) {
                repository.getRepositoryPopularMovies()
            }
            data2.postValue(moviesDetails.await())
            Log.d("DETAILS", moviesDetails.await().toString())
        }
    }

    fun getViewModelMovieDetails(id: Int) {
        viewModelScope.launch {
            val moviesDetails = withContext(Dispatchers.IO) {
                repository.getRepositoryMovieDetailsById(id)
            }
            data2.postValue(moviesDetails)
        }
    }
}