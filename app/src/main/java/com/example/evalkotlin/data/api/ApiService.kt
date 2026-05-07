package com.example.evalkotlin.data.api

import com.example.evalkotlin.data.api.dto.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "Content-Type: application/json",
        "x-rapidapi-host: netflix54.p.rapidapi.com",
        "x-rapidapi-key: e4bb6ca762msheada7c82a82beccp101260jsn5feff6e358ed"
    )

    @GET("search/")

    suspend fun search(
        @Query("query") query: String,
        @Query("offset") offset: String = "0",
        @Query("limit_titles") limit: String = "20",
        @Query("lang") lang: String = "en"
    ): ApiResponse
}