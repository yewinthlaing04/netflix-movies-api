package com.example.evalkotlin.screens.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarComponent(
    text: String,
    onTextChange: (String) -> Unit
) {

    SearchBar(
        query = text,
        onQueryChange = onTextChange,
        onSearch = {},
        active = false,
        onActiveChange = {},
        placeholder = {
            Text("Search...")
        },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        }
    ) {}
}