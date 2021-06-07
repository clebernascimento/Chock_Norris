package com.example.desafiopulsus.data.api

import com.example.desafiopulsus.BuildConfig
import com.example.desafiopulsus.data.api.RetrofitBuilder.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = BuildConfig.BASE_URL

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}