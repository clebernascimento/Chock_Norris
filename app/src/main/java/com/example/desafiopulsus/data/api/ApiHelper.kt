package com.example.desafiopulsus.data.api

import com.example.desafiopulsus.data.model.api.ApiService

class ApiHelper(private val apiService: ApiService) {
    suspend fun getJokes() = apiService.getJokes()
}