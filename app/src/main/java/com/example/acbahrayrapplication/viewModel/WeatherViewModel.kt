package com.example.acbahrayrapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acbahrayrapplication.data.ApiClient
import com.example.acbahrayrapplication.model.WeatherModel
import com.example.acbahrayrapplication.repo.WeatherRepo
import com.example.acbahrayrapplication.util.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherViewModel(private val weatherRepo: WeatherRepo) : ViewModel() {

    private val _getWeatherData = MutableLiveData<Response<WeatherModel>>()
    val getWeatherData: LiveData<Response<WeatherModel>> = _getWeatherData


    fun getWeatherData(id: Long, apiKey: String) {
        _getWeatherData.value = Response.loading(null)
        viewModelScope.launch {
            val response = weatherRepo.getWeatherData(id, apiKey)
            withContext(Dispatchers.Main) {
                _getWeatherData.value = response
            }
        }
    }

}