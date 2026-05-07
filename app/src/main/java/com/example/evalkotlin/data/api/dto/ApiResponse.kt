package com.example.evalkotlin.data.api.dto

data class NetflixResponse(
    val items: List<NetflixItem>
)

data class NetflixItem(
    val title: String?,
    val image: String?
)