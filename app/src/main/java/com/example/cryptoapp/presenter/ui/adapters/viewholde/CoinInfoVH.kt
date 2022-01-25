package com.example.cryptoapp.presenter.ui.adapters.viewholde

import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.ItemCoinInfoBinding
import javax.inject.Inject

class CoinInfoVH @Inject constructor(
    val binding: ItemCoinInfoBinding
) : RecyclerView.ViewHolder(binding.root)