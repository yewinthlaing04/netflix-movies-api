package com.example.evalkotlin.model

data class MediaItem(

    val title: String,
    val image: String? = null,
    val isFavorite: Boolean = false
)