package com.example.evalkotlin.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evalkotlin.data.repository.NetflixRepository
import com.example.evalkotlin.model.MediaItem

import kotlinx.coroutines.launch

class NetflixViewModel : ViewModel() {

    private val repository = NetflixRepository()

    var movies by mutableStateOf<List<MediaItem>>(emptyList())
        private set

    init {

        fetchMovies()
    }

    private fun fetchMovies() {

        viewModelScope.launch {

            try {

                val response =
                    repository.searchMovies("batman")

                movies = response.items.map {

                    MediaItem(
                        title = it.title ?: "",
                        image = it.image
                    )
                }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }

    fun toggleFavorite(item: MediaItem) {

        movies = movies.map {

            if (it.title == item.title)
                it.copy(isFavorite = !it.isFavorite)
            else it
        }
    }
}