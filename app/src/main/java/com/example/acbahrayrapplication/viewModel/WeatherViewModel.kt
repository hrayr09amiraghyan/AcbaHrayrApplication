package com.example.acbahrayrapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acbahrayrapplication.data.ApiClient
import com.example.acbahrayrapplication.model.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel(private val apiClient: ApiClient) : ViewModel() {


    private val _getWeatherData = MutableLiveData<WeatherModel>()
    val getWeatherData: LiveData<WeatherModel> = _getWeatherData


    fun getWeatherData(id: Long, apiKey: String) {
        viewModelScope.launch {
            val response = apiClient.getWatherForecastForOneDay(id, apiKey)
            if (response.isSuccessful && response.body() != null) {
                _getWeatherData.postValue(response.body())
            }
        }
    }

}