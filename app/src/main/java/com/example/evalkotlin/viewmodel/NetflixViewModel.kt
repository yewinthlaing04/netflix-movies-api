package com.example.evalkotlin.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evalkotlin.data.repository.NetflixRepository
import com.example.evalkotlin.model.MediaItem
import kotlinx.coroutines.launch

class NetflixViewModel : ViewModel() {

    private val repo = NetflixRepository()

    var movies by mutableStateOf<List<MediaItem>>(emptyList())
        private set

    var series by mutableStateOf<List<MediaItem>>(emptyList())
        private set

    var favorites by mutableStateOf<List<MediaItem>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        fetchInitialData()
    }

    private fun fetchInitialData() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                val movieResponse = repo.getTrendingMovies()
                movies = movieResponse.results.map {
                    MediaItem(
                        title = it.name,
                        image = it.posterPath
                    )
                }

                val seriesResponse = repo.getTrendingSeries()
                series = seriesResponse.results.map {
                    MediaItem(
                        title = it.name,
                        image = it.posterPath
                    )
                }
            } catch (e: Exception) {
                errorMessage = "Failed to load data: ${e.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }

    fun toggleFavorite(item: MediaItem) {
        fun update(list: List<MediaItem>) =
            list.map {
                if (it.title == item.title)
                    it.copy(isFavorite = !it.isFavorite)
                else it
            }

        movies = update(movies)
        series = update(series)

        favorites = (movies + series).filter { it.isFavorite }.distinctBy { it.title }
    }
}
