package com.example.nasdaq.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface StockApi {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json",
        "x-rapidapi-ua: RapidAPI-Playground",
        "x-rapidapi-key: 99ce56a1a0msha23dcce4e8f1a70p17f625jsn0e0d7f49bc37",
        "x-rapidapi-host: realstonks.p.rapidapi.com"
    )
    @GET("stocks/{symbol}")
    suspend fun getStockData(@Path("symbol") symbol: String): Response<StockResponse>
}
