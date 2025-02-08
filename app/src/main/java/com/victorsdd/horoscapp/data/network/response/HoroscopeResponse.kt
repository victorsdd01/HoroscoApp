package com.victorsdd.horoscapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.victorsdd.horoscapp.domain.model.ResponseModel

data class HoroscopeResponse(
        @SerializedName("date") val date : String,
        @SerializedName("horoscope") val horoscope : String,
        @SerializedName("sign") val sign : String,
){
        /**
         * Map the horoscope response to Response model...
         */

        fun responseToDomain() : ResponseModel {
                return ResponseModel(
                        horoscope = horoscope,
                        sign = sign
                )
        }
}