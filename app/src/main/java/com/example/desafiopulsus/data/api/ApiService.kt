package com.example.desafiopulsus.data.model.api

import com.example.desafiopulsus.data.model.Jokes
import retrofit2.http.GET

interface ApiService {
    @GET("jokes/random")
    suspend fun getJokes():List<Jokes>
}