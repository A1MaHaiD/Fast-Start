package com.example.cryptoapp.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.databinding.ActivityCoinDetailBinding
import com.example.cryptoapp.viewModels.CoinViewModel
import com.squareup.picasso.Picasso

lateinit var binding: ActivityCoinDetailBinding
private lateinit var viewModel: CoinViewModel

class CoinDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_coin_detail)
        ActivityCoinDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }
        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        if (fromSymbol != null) {
            viewModel.getDetailInfo(fromSymbol).observe(this, Observer {
                with(binding) {
                    tvPrice.text = it.price.toString()
                    tvMinPrice.text = it.lowDay.toString()
                    tvMaxPrice.text = it.highDay.toString()
                    tvLastMarket.text = it.lastMarket.toString()
                    tvLastUpdate.text = it.getFormattedTime()
                    tvFromSymbol.text = it.fromSymbol
                    tvToSymbol.text = it.toSymbol
                    Picasso.get().load(it.getFullImageUrl()).into(ivLogoCoin)
                }


            })
        }
        Log.i("DETAIL_INFO", fromSymbol?.length.toString())
    }

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"

        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}