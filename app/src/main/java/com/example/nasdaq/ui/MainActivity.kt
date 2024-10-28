package com.example.nasdaq.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.nasdaq.R
import com.example.nasdaq.data.repository.StockRepository
import com.example.nasdaq.data.remote.RetrofitInstance
import com.example.nasdaq.data.remote.StockResponse
import com.example.nasdaq.viewmodel.StockViewModel
import com.example.nasdaq.viewmodel.StockViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val stockViewModel: StockViewModel by viewModels {
        StockViewModelFactory(StockRepository(RetrofitInstance.api))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)

        // Ініціалізуємо адаптер з пустим списком
        viewPagerAdapter = ViewPagerAdapter(emptyList())
        viewPager.adapter = viewPagerAdapter


        // Спостерігаємо за даними акцій
        stockViewModel.aaplData.observe(this) { aapl ->
            updateAdapterData()
        }

        stockViewModel.nvdaData.observe(this) { nvda ->
            updateAdapterData()
        }

        stockViewModel.msftData.observe(this) { msft ->
            updateAdapterData()
        }

        stockViewModel.fetchStocksData()
    }

    private fun updateAdapterData() {
        // Отримуємо всі дані акцій в один список
        val stocksList = listOfNotNull(
            stockViewModel.aaplData.value,
            stockViewModel.nvdaData.value,
            stockViewModel.msftData.value
        )
        // Оновлюємо адаптер з новими даними
        viewPagerAdapter.updateStocks(stocksList)
    }
}
