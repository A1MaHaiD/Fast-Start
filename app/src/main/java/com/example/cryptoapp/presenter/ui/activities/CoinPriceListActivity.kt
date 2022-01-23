package com.example.cryptoapp.presenter.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.databinding.ActivityCoinPriceListBinding
import com.example.cryptoapp.domain.entity.CoinInfoEntity
import com.example.cryptoapp.presenter.ui.adapters.CoinInfoAdapter
import com.example.cryptoapp.presenter.view_models.CoinViewModel


class CoinPriceListActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinViewModel
    private val binding by lazy {
        ActivityCoinPriceListBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinInfoDTO: CoinInfoEntity) {
                CoinDetailActivity.newIntent(
                    this@CoinPriceListActivity,
                    coinInfoDTO.fromSymbol
                ).apply {
                    startActivity(intent)
                }
            }
        }
        binding.rvCoinPriceList.adapter = adapter
        binding.rvCoinPriceList.itemAnimator = null
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.coinInfoList.observe(this) {
            adapter.submitList(it)
        }
    }
}