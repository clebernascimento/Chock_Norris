package com.example.desafiopulsus.ui.main.viewModel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.desafiopulsus.data.repository.MainRepository
import com.example.desafiopulsus.utils.Resources
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getJokes() = liveData(Dispatchers.IO) {
        emit(Resources.loading(data = null))
        try {
            emit(Resources.success(data = mainRepository.getJokes()))
        } catch (exception: Exception) {
            emit(
                Resources.error(
                    data = null,
                    message = exception.message ?: "Erro ao listar Jokes"
                )
            )
        }
    }
}