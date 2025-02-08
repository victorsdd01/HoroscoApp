package com.victorsdd.horoscapp.domain.repository
import com.victorsdd.horoscapp.domain.model.ResponseModel

interface Repository {
    suspend fun getPrediction(sign:String) : ResponseModel?
}