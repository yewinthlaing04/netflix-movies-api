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

    init {
        fetchMovies("batman")
        fetchSeries("dark")
    }

    fun fetchMovies(query: String) {

        viewModelScope.launch {

            val response = repo.search(query)

            movies = response.titles.map {

                MediaItem(
                    title = it.title ?: "",
                    image = it.jawSummary?.backgroundImage?.url
                )
            }
        }
    }

    fun fetchSeries(query: String) {

        viewModelScope.launch {

            val response = repo.search(query)

            series = response.titles.map {

                MediaItem(
                    title = it.title ?: "",
                    image = it.jawSummary?.backgroundImage?.url
                )
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

        favorites =
            (movies + series).filter { it.isFavorite }
    }
}