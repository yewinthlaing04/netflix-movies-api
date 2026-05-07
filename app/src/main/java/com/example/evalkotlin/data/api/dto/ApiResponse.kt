package com.example.evalkotlin.data.api.dto

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    val page: Int,
    val results: List<MovieDto>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)

data class MovieDto(
    val id: Int,
    val name: String,
    val description: String,
    @SerializedName("favorite_count") val favoriteCount: Int,
    @SerializedName("item_count") val itemCount: Int,
    @SerializedName("iso_639_1") val iso6391: String,
    @SerializedName("list_type") val listType: String,
    @SerializedName("poster_path") val posterPath: String?
)
