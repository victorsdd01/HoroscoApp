package com.victorsdd.horoscapp.data.core.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val tokenManager: TokenManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .header(name = "Authorization", value = "Bearer ${tokenManager.token()}")
        return chain.proceed(request.build())
    }
}


class TokenManager @Inject constructor() {
    fun token(): String {
        return "Este es el token...."
    }
}