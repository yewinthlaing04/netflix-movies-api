package com.example.evalkotlin.data.repository

import com.example.evalkotlin.data.api.ApiInstance

class NetflixRepository {

    suspend fun search(query: String) =
        ApiInstance.api.search(query)
}