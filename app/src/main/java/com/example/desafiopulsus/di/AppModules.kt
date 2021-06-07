package com.example.desafiopulsus.di

import com.example.desafiopulsus.BuildConfig
import com.example.desafiopulsus.data.api.ApiService
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModules {
    val Project = module {
        single(named("ApiService")) { provideApiChock() }
    }

    private fun provideApiChock(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}