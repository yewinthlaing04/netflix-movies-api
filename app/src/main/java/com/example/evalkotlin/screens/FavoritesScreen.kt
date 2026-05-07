package com.example.evalkotlin.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.evalkotlin.model.MediaItem
import com.example.evalkotlin.screens.components.MovieCard

@Composable
fun FavoritesScreen(
    favorites: List<MediaItem>,
    onToggleFavorite: (MediaItem) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Favorites",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(favorites) { item ->

                MovieCard(
                    item = item,
                    onFavoriteClick = {
                        onToggleFavorite(item)
                    }
                )
            }
        }
    }
}