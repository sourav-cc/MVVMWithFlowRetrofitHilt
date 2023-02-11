package com.example.setup1.ui

import com.example.setup1.data.ApiService
import com.example.setup1.data.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getDataFromApi() = flow {
        emit(NetworkResult.Loading(true))
        val response = apiService.getSampleData()
        emit(NetworkResult.Success(response))
    }.catch { e->
        emit(NetworkResult.Failure(e.message ?: "Unknown error"))
    }

}