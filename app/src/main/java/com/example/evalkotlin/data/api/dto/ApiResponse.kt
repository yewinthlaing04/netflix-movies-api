package com.example.evalkotlin.data.api.dto

data class ApiResponse(
    val titles: List<NetflixItem>
)

data class NetflixItem(
    val title: String?,
    val jawSummary: JawSummary?
)

data class JawSummary(
    val backgroundImage: ImageData?
)

data class ImageData(
    val url: String?
)