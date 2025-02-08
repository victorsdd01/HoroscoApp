package com.victorsdd.horoscapp.domain.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    val horoscope : String,
    val sign : String,
)