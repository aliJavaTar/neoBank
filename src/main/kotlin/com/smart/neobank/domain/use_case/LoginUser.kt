package com.smart.neobank.domain.use_case

import com.smart.neobank.infrastructure.jpa.UserJpaRepository
import com.smart.neobank.infrastructure.mapper.UserMapper
import com.smart.neobank.presentation.request.UserLoginRequest
import com.smart.neobank.presentation.response.UserLoginResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginUser(
    private val repository: UserJpaRepository,
    private val mapper: UserMapper,
    private val encoder: PasswordEncoder
) {

    fun register(request: UserLoginRequest): UserLoginResponse {
        val user = mapper.convertToEntity(request)
        user.password = encoder.encode(user.password)
        val userEntity = repository.save(user)
        return mapper.convertToResponse(userEntity)
    }
}