package com.cesar.appmvvm.data.repository

import com.cesar.appmvvm.data.model.UserProvider
import com.cesar.appmvvm.data.model.request.LoginRequest
import com.cesar.appmvvm.data.model.response.LoginResponse
import com.cesar.appmvvm.data.network.AuthApiService

class AuthRepository {
    private val authApiService = AuthApiService()

    suspend fun login(loginRequest: LoginRequest): LoginResponse{
        val response = authApiService.login(loginRequest)
        if (response.status == "success"){
        UserProvider.user = response.data
        }
        return response
    }
}