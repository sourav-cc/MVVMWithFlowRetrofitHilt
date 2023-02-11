package com.example.setup1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.setup1.data.NetworkResult
import com.example.setup1.data.model.SampleResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {

    private var _souravResponse = MutableLiveData<NetworkResult<SampleResponse>>()
    val souravResponse: LiveData<NetworkResult<SampleResponse>> = _souravResponse

     fun getDataFromApi(){
        viewModelScope.launch {
            mainRepository.getDataFromApi().collect{
                _souravResponse.postValue(it)
            }
        }
    }
}