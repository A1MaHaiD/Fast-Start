package com.example.cryptoapp.data.mapper

import com.example.cryptoapp.data.database.CoiInfoDBModel
import com.example.cryptoapp.data.network.dto.CoinInfoDTO
import com.example.cryptoapp.data.network.dto.CoinJsonContainerDTO
import com.example.cryptoapp.data.network.dto.CoinNamesListDTO
import com.example.cryptoapp.domain.entity.CoinInfoEntity
import com.google.gson.Gson

class CoinMapper {

    fun mapDtoToModel(coinDTO: CoinInfoDTO): CoiInfoDBModel {
        return CoiInfoDBModel(
            fromSymbol = coinDTO.fromSymbol,
            toSymbol = coinDTO.toSymbol,
            price = coinDTO.price,
            lastUpdate = coinDTO.lastUpdate,
            highDay = coinDTO.highDay,
            lowDay = coinDTO.lowDay,
            lastMarket = coinDTO.lastMarket,
            imageUrl = coinDTO.imageUrl
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
            lastUpdate = coinDBModel.lastUpdate,
            highDay = coinDBModel.highDay,
            lowDay = coinDBModel.lowDay,
            lastMarket = coinDBModel.lastMarket,
            imageUrl = coinDBModel.imageUrl
        )
    }
}