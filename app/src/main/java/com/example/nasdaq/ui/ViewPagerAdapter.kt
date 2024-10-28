package com.example.nasdaq.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasdaq.R
import com.example.nasdaq.data.remote.StockResponse

class ViewPagerAdapter(private var stocks: List<StockResponse>) :
    RecyclerView.Adapter<ViewPagerAdapter.StockViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)

        return StockViewHolder(view)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        holder.bind(stocks[position])

    }

    override fun getItemCount(): Int = stocks.size

    // Новий метод для оновлення даних
    fun updateStocks(newStocks: List<StockResponse>) {
        stocks = newStocks
        notifyDataSetChanged() // Оновлюємо адаптер
    }

    inner class StockViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val stockName = view.findViewById<TextView>(R.id.stockName)
        private val stockPrice = view.findViewById<TextView>(R.id.stockLastPrice)
        private val stockOpenPrice = view.findViewById<TextView>(R.id.stockOpenPrice)
        private val stockHighPrice = view.findViewById<TextView>(R.id.stockHighPrice)
        private val stockVolume = view.findViewById<TextView>(R.id.stockVolume)
        private val stockChange = view.findViewById<TextView>(R.id.stockPriceChange)
        private val stockPercentageChange = view.findViewById<TextView>(R.id.stockPercentChange)
        private val stockLowPrice = view.findViewById<TextView>(R.id.stockLowPrice)
        private val stockSymbol = view.findViewById<TextView>(R.id.stockSymbol)


        fun bind(stock: StockResponse) {

            stockName.text = stock.symbolName
            stockPrice.text = "Last Price: ${stock.lastPrice}"
            stockOpenPrice.text = "Open Price: ${stock.openPrice}"
            stockHighPrice.text = "High Price: ${stock.highPrice}"
            stockVolume.text = "Volume: ${stock.volume}"
            stockLowPrice.text = "Low Price:  ${stock.lowPrice}"
            stockChange.text = "Price Change: ${stock.priceChange}"
            stockPercentageChange.text = "Percent Change: ${stock.percentChange}%"
            stockSymbol.text = stock.symbol
        }

    }
}
