package io.donatogomez.themoviedb.view.series

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.donatogomez.themoviedb.data.repository.Repository
import io.donatogomez.themoviedb.model.presentation.SeriePresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val data: MutableLiveData<List<SeriePresentation>> = MutableLiveData()

    fun getViewModelPopularSeries() {
        viewModelScope.launch {
            val series = withContext(Dispatchers.IO) {
                repository.getRepositoryPopularSeries()
            }
            data.postValue(series)
        }
    }
}