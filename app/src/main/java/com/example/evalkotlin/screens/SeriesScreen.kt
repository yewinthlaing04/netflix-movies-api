package com.example.evalkotlin.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.evalkotlin.model.MediaItem
import com.example.evalkotlin.screens.components.MovieCard
import com.example.evalkotlin.screens.components.SearchBarComponent

@Composable
fun SeriesScreen(
    series: List<MediaItem>,
    onToggleFavorite: (MediaItem) -> Unit
) {

    var searchText by remember {
        mutableStateOf("")
    }

    val filtered = series.filter {
        it.title.contains(searchText, true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Netflix Series",
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

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(filtered) { serie ->

                MovieCard(
                    item = serie,
                    onFavoriteClick = {
                        onToggleFavorite(serie)
                    }
                )
            }
        }
    }
}