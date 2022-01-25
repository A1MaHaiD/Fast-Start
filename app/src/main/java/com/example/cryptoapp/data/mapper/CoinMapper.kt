package com.example.cryptoapp.data.mapper

import com.example.cryptoapp.data.database.CoiInfoDBModel
import com.example.cryptoapp.data.network.dto.CoinInfoDTO
import com.example.cryptoapp.data.network.dto.CoinJsonContainerDTO
import com.example.cryptoapp.data.network.dto.CoinNamesListDTO
import com.example.cryptoapp.domain.entity.CoinInfoEntity
import com.google.gson.Gson
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CoinMapper @Inject constructor() {

    fun mapDtoToModel(coinDTO: CoinInfoDTO): CoiInfoDBModel {
        return CoiInfoDBModel(
            fromSymbol = coinDTO.fromSymbol,
            toSymbol = coinDTO.toSymbol,
            price = coinDTO.price,
            lastUpdate = coinDTO.lastUpdate,
            highDay = coinDTO.highDay,
            lowDay = coinDTO.lowDay,
            lastMarket = coinDTO.lastMarket,
            imageUrl = BASE_IMAGE_URL + coinDTO.imageUrl
        )
    }

    fun mapJsonContainerToListCoinInfoDTO(jsonContainer: CoinJsonContainerDTO): List<CoinInfoDTO> {
        val result = mutableListOf<CoinInfoDTO>()
        val jsonObject = jsonContainer.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDTO::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(namesListDTO: CoinNamesListDTO): String {
        return namesListDTO.names?.map {
            it.coinName?.name
        }?.joinToString(",") ?: ""
    }

    fun mapModelToEntity(coinDBModel: CoiInfoDBModel): CoinInfoEntity {
        return CoinInfoEntity(
            fromSymbol = coinDBModel.fromSymbol,
            toSymbol = coinDBModel.toSymbol,
            price = coinDBModel.price,
            lastUpdate = convertTimestampToTime(coinDBModel.lastUpdate),
            highDay = coinDBModel.highDay,
            lowDay = coinDBModel.lowDay,
            lastMarket = coinDBModel.lastMarket,
            imageUrl = coinDBModel.imageUrl
        )
    }

    private fun convertTimestampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    companion object {
        const val BASE_IMAGE_URL = "https://cryptocompare.com"
    }
}