package com.example.nasdaq.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasdaq.data.remote.StockResponse
import com.example.nasdaq.data.repository.StockRepository
import kotlinx.coroutines.launch

class StockViewModel(private val repository: StockRepository) : ViewModel() {

    val aaplData: MutableLiveData<StockResponse> = MutableLiveData()
    val nvdaData: MutableLiveData<StockResponse> = MutableLiveData()
    val msftData: MutableLiveData<StockResponse> = MutableLiveData()

    fun fetchStocksData() {
        viewModelScope.launch {
            fetchStockData("AAPL", aaplData)
            fetchStockData("NVDA", nvdaData)
            fetchStockData("MSFT", msftData)
        }
    }

    private suspend fun fetchStockData(symbol: String, liveData: MutableLiveData<StockResponse>) {
        val response = repository.getStockData(symbol)
        if (response.isSuccessful) {
            liveData.postValue(response.body())
        } else {
        }
    }
}
