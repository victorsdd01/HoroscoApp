package com.victorsdd.horoscapp.ui.detail

import com.victorsdd.horoscapp.domain.model.HoroscopeModel

/**
 * state class for detail view
 * */
sealed class DetailState {

    data object Loading : DetailState()
    data class Error(val error: String) : DetailState()
    data class Success(val prediction: String, val sign: String, val horoscopeModel: HoroscopeModel) : DetailState()

}