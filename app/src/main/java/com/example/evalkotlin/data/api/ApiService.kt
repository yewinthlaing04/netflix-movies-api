package com.example.evalkotlin.data.api

import com.example.evalkotlin.data.api.dto.NetflixResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "X-RapidAPI-Key: YOUR_API_KEY",
        "X-RapidAPI-Host: netflix54.p.rapidapi.com"
    )

    @GET("search/")
    suspend fun searchTitles(

        @Query("query") query: String

    ): NetflixResponse
}