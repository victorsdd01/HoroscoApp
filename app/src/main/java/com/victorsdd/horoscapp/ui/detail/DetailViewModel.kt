package com.victorsdd.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victorsdd.horoscapp.domain.model.HoroscopeModel
import com.victorsdd.horoscapp.domain.usecases.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase): ViewModel() {

    private val _state = MutableStateFlow<DetailState>(DetailState.Loading)
    val state : StateFlow<DetailState> = _state

    lateinit var horoscope : HoroscopeModel
    fun getHoroscope(sign: HoroscopeModel){
        horoscope = sign
        viewModelScope.launch {
            _state.value = DetailState.Loading
            // secondary thread
            val result = withContext(Dispatchers.IO) {
                getPredictionUseCase(sign.name)
            }
            if (result != null) {
                _state.value = DetailState.Success(result.horoscope, result.sign, horoscope)
            } else {
                _state.value = DetailState.Error("Ha ocurrido un error, intentelo mas tarde")
            }
        }
    }
}