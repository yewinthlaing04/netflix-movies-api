package com.example.evalkotlin.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.evalkotlin.model.MediaItem

@Composable
fun MovieCard(
    item: MediaItem,
    onFavoriteClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),

            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

                IconButton(
                    onClick = onFavoriteClick
                ) {

                    Icon(
                        imageVector =
                            if (item.isFavorite)
                                Icons.Default.Favorite
                            else
                                Icons.Outlined.FavoriteBorder,

                        contentDescription = null
                    )
                }
            }
        }
    }
}