package com.example.evalkotlin.data.repository

import com.example.evalkotlin.data.api.ApiInstance

class NetflixRepository {

    suspend fun searchMovies(query: String) =

        ApiInstance.api.searchTitles(query)
}