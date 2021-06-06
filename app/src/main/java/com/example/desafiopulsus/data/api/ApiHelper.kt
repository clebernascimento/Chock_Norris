package com.example.desafiopulsus.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getJokes() = apiService.getJokes()
}