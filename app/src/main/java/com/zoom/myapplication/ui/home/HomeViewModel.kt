package com.zoom.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zoom.myapplication.model.ApiResponse
import com.zoom.myapplication.network.RetrofitClient
import com.zoom.myapplication.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val repository: HomeRepository
    private val _response = MutableLiveData<Response<ApiResponse>>()
    val response: LiveData<Response<ApiResponse>>
        get() = _response

    init {
        val api = RetrofitClient.instance
        repository = HomeRepository(api)
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.fetchData()
            _response.postValue(response)
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}
