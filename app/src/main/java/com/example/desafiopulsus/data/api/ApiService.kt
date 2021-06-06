package com.example.desafiopulsus.data.api

import com.example.desafiopulsus.data.model.Joke
import com.example.desafiopulsus.data.model.Jokes
import retrofit2.http.GET

interface ApiService {
    @GET("jokes/random")
    suspend fun getJokes(): Joke
}