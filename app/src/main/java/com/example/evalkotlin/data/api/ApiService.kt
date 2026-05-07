package com.example.evalkotlin.data.api

import com.example.evalkotlin.data.api.dto.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("trending/movie/week")
    suspend fun getTrendingMovies(): ApiResponse

    @GET("trending/series/week")
    suspend fun getTrendingSeries(): ApiResponse

    @GET("search")
    suspend fun search(@Query("query") query: String): ApiResponse
}
