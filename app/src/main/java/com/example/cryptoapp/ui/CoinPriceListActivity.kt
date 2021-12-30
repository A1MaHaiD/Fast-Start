package com.example.cryptoapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.adapters.CoinInfoAdapter
import com.example.cryptoapp.databinding.ActivityCoinPriceListBinding
import com.example.cryptoapp.pojo.CoinPriceInfo
import com.example.cryptoapp.viewModels.CoinViewModel


class CoinPriceListActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinViewModel
    lateinit var binding: ActivityCoinPriceListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("CoinPriceListActivity", "onCreate")
        binding = ActivityCoinPriceListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent = CoinDetailActivity.newIntent(this@CoinPriceListActivity,
                coinPriceInfo.fromSymbol)
                startActivity(intent)
                Log.i("onCoinClick","startActivity")
            }

        }
        binding.rvCoinPriceList.adapter = adapter
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.priceList.observe(this, Observer {
            adapter.coinInfoList = it
            Log.i("CoinPriceListActivity", "PriceList show in recycler")
        })
    }
}