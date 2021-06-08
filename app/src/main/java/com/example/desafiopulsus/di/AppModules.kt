package com.example.desafiopulsus.di

import androidx.lifecycle.ViewModel
import com.example.desafiopulsus.BuildConfig
import com.example.desafiopulsus.data.api.ApiHelper
import com.example.desafiopulsus.data.api.ApiService
import com.example.desafiopulsus.data.repository.MainRepository
import com.example.desafiopulsus.ui.main.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModules {
    val Project = module {
        single { provideApiChock() }
        single { MainRepository(get()) }
        single { ApiHelper(get()) }
        viewModel { MainViewModel(get()) }
    }

    private fun provideApiChock(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}