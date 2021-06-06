package com.example.desafiopulsus.ui.main.viewModel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiopulsus.data.api.ApiHelper
import com.example.desafiopulsus.data.repository.MainRepository
import com.example.desafiopulsus.ui.main.viewModel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Nome de classe desconhecido")
    }
}