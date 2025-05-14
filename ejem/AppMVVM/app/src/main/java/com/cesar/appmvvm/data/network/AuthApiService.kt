package com.cesar.appmvvm.data.network

import com.cesar.appmvvm.core.RetrofitHelper
import com.cesar.appmvvm.data.model.request.LoginRequest
import com.cesar.appmvvm.data.model.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthApiService {
    private val retrofitAuth = RetrofitHelper.getRetrofitAuth()

    suspend fun  login(loginRequest: LoginRequest):LoginResponse{
        return withContext(Dispatchers.IO){
            val response = retrofitAuth.create(AuthApiClient::class.java).login(loginRequest)
            response.body() ?: LoginResponse("Problemas con el servidor", null, "error")
        }
    }
}