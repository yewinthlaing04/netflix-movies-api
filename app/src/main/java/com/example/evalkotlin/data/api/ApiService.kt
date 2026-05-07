package com.example.evalkotlin.data.api

import com.example.evalkotlin.data.api.dto.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "X-RapidAPI-Key: apiendpoint_e4b77907-4829-46d9-a8ca-bd74d8d8e198",
        "X-RapidAPI-Host: netflix54.p.rapidapi.com"
    )

    @GET("search/")

    suspend fun search(
        @Query("query") query: String,
        @Query("offset") offset: String = "0",
        @Query("limit_titles") limit: String = "20",
        @Query("lang") lang: String = "en"
    ): ApiResponse
}