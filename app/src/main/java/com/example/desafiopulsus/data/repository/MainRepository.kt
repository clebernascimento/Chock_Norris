package com.example.desafiopulsus.data.repository

import com.example.desafiopulsus.data.api.ApiHelper
import com.example.desafiopulsus.data.model.Joke

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getJokes(): Joke {
        return apiHelper.getJokes()
    }
}