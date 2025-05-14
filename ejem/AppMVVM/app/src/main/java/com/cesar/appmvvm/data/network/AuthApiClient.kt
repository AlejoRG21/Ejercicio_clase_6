package com.cesar.appmvvm.data.network

import com.cesar.appmvvm.data.model.request.LoginRequest
import com.cesar.appmvvm.data.model.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import java.net.CacheRequest

interface AuthApiClient {
    @POST("sing_in")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}