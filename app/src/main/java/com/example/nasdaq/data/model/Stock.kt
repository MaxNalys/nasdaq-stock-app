package com.example.nasdaq.data.model

data class Stock(
    val symbol: String,
    val symbolName: String,
    val lastPrice: Double,
    val priceChange: String, // змінили тип на String
    val percentChange: Double,
    val lowPrice: Double,
    val openPrice: Double,
    val highPrice: Double,
    val volume: Double,
)
