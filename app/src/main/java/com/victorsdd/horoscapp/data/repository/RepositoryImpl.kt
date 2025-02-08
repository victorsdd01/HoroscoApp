package com.victorsdd.horoscapp.data.repository

import android.util.Log
import com.victorsdd.horoscapp.data.network.ApiService
import com.victorsdd.horoscapp.domain.model.ResponseModel
import com.victorsdd.horoscapp.domain.repository.Repository
import javax.inject.Inject

/**
 * This is the repository impl...
 * */

class RepositoryImpl @Inject constructor(private val apiService : ApiService) : Repository {
    override suspend fun getPrediction(sign: String) : ResponseModel? {
        runCatching {
            apiService.getHoroscope(sign)
        }.onSuccess {
            return it.responseToDomain()
        }.onFailure {
            Log.e("error", "ha ocurrido un error${it.message}")
        }
        return null
    }
}