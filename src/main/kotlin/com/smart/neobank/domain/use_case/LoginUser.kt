package com.smart.neobank.domain.use_case

import com.smart.neobank.infrastructure.jpa.UserJpaRepository
import com.smart.neobank.presentation.request.UserLoginRequest
import org.springframework.stereotype.Service

@Service
class LoginUser(private val repository: UserJpaRepository) {

    fun register(request: UserLoginRequest): UserLoginRequest {
        repository.save()
    }
}