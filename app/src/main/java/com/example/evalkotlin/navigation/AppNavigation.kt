package com.example.evalkotlin.navigation


import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.evalkotlin.data.moviesList
import com.example.evalkotlin.data.seriesList
import com.example.evalkotlin.model.MediaItem
import com.example.evalkotlin.screens.*

@Composable
fun AppNavigation(
    navController: NavHostController
) {

    var movies by remember {
        mutableStateOf(moviesList)
    }

    var series by remember {
        mutableStateOf(seriesList)
    }

    fun toggleFavorite(item: MediaItem) {

        movies = movies.map {
            if (it.title == item.title)
                it.copy(isFavorite = !it.isFavorite)
            else it
        }

        series = series.map {
            if (it.title == item.title)
                it.copy(isFavorite = !it.isFavorite)
            else it
        }
    }

    val favorites =
        movies.filter { it.isFavorite } +
                series.filter { it.isFavorite }

    NavHost(
        navController = navController,
        startDestination = "movies"
    ) {

        composable("movies") {

            MoviesScreen(
                movies = movies,
                onToggleFavorite = {
                    toggleFavorite(it)
                }
            )
        }

        composable("series") {

            SeriesScreen(
                series = series,
                onToggleFavorite = {
                    toggleFavorite(it)
                }
            )
        }

        composable("favorites") {

            FavoritesScreen(
                favorites = favorites,
                onToggleFavorite = {
                    toggleFavorite(it)
                }
            )
        }
    }
}