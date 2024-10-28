package com.example.nasdaq.data.repository

import com.example.nasdaq.data.remote.StockApi
import com.example.nasdaq.data.remote.StockResponse
import retrofit2.Response

class StockRepository(private val api: StockApi) {

    suspend fun getStockData(symbol: String): Response<StockResponse> {
        return api.getStockData(symbol)
    }

    suspend fun getAAPLData(): Response<StockResponse> = getStockData("AAPL")
    suspend fun getNVDAData(): Response<StockResponse> = getStockData("NVDA")
    suspend fun getMSFTData(): Response<StockResponse> = getStockData("MSFT")
}
