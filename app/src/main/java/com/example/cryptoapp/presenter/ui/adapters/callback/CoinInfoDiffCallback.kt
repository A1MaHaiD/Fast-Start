package com.example.cryptoapp.presenter.ui.adapters.callback

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.domain.entity.CoinInfoEntity

object CoinInfoDiffCallback : DiffUtil.ItemCallback<CoinInfoEntity>() {
    override fun areItemsTheSame(oldItem: CoinInfoEntity, newItem: CoinInfoEntity): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CoinInfoEntity, newItem: CoinInfoEntity): Boolean {
        return oldItem == newItem
    }
}