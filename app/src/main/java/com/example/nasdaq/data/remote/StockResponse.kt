package com.example.nasdaq.data.remote

import com.google.gson.annotations.SerializedName

data class StockResponse(
    @SerializedName("symbol") val symbol: String,
    @SerializedName("symbolName") val symbolName: String,
    @SerializedName("lastPrice") val lastPrice: Double,
    @SerializedName("priceChange") val priceChange: String, // змінили тип на String
    @SerializedName("percentChange") val percentChange: Double,
    @SerializedName("volume") val volume: Double,
    @SerializedName("highPrice") val highPrice: Double,
    @SerializedName("lowPrice") val lowPrice: Double,
    @SerializedName("openPrice") val openPrice: Double
)
