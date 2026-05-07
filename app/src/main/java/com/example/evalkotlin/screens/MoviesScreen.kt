package com.example.evalkotlin.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.evalkotlin.model.MediaItem
import com.example.evalkotlin.screens.components.MovieCard
import com.example.evalkotlin.screens.components.SearchBarComponent

@Composable
fun MoviesScreen(
    movies: List<MediaItem>,
    isLoading: Boolean = false,
    errorMessage: String? = null,
    onToggleFavorite: (MediaItem) -> Unit
) {

    var searchText by remember {
        mutableStateOf("")
    }

    val filtered = movies.filter {
        it.title.contains(searchText, true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Netflix Movies",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        SearchBarComponent(
            text = searchText,
            onTextChange = {
                searchText = it
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.fillMaxSize()) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else if (errorMessage != null) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(filtered) { movie ->
                        MovieCard(
                            item = movie,
                            onFavoriteClick = {
                                onToggleFavorite(movie)
                            }
                        )
                    }
                }
            }
        }
    }
}