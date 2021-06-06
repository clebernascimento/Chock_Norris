package com.example.desafiopulsus.data.repository

import com.example.desafiopulsus.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getJokes() = apiHelper.getJokes()
}