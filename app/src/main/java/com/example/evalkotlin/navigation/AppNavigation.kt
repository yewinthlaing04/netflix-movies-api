package com.example.evalkotlin.navigation


import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.evalkotlin.screens.*
import com.example.evalkotlin.viewmodel.NetflixViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    viewModel: NetflixViewModel = viewModel()
) {
    val movies = viewModel.movies
    val series = viewModel.series
    val favorites = viewModel.favorites
    val isLoading = viewModel.isLoading
    val errorMessage = viewModel.errorMessage

    NavHost(
        navController = navController,
        startDestination = "movies"
    ) {

        composable("movies") {

            MoviesScreen(
                movies = movies,
                isLoading = isLoading,
                errorMessage = errorMessage,
                onToggleFavorite = {
                    viewModel.toggleFavorite(it)
                }
            )
        }

        composable("series") {

            SeriesScreen(
                series = series,
                isLoading = isLoading,
                errorMessage = errorMessage,
                onToggleFavorite = {
                    viewModel.toggleFavorite(it)
                }
            )
        }

        composable("favorites") {

            FavoritesScreen(
                favorites = favorites,
                onToggleFavorite = {
                    viewModel.toggleFavorite(it)
                }
            )
        }
    }
}