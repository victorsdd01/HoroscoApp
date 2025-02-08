package com.victorsdd.horoscapp.data.network

import com.victorsdd.horoscapp.data.network.response.HoroscopeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign: String): HoroscopeResponse

}