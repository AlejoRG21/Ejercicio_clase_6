package com.cesar.appmvvm.domain

import com.cesar.appmvvm.data.model.request.LoginRequest
import com.cesar.appmvvm.data.model.response.LoginResponse
import com.cesar.appmvvm.data.repository.AuthRepository

class PostLoginUseCase {
    private val authRepository = AuthRepository()

    suspend operator fun invoke(loginRequest: LoginRequest): LoginResponse{
        return authRepository.login(loginRequest)
    }
}