package com.victorsdd.horoscapp.domain.usecases

import com.victorsdd.horoscapp.domain.repository.Repository
import javax.inject.Inject

/**
 * use cases....
 * */
class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)

}