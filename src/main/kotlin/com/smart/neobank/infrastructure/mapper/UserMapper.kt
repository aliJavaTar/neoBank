package com.smart.neobank.infrastructure.mapper

import com.smart.neobank.infrastructure.jpa.entity.User
import com.smart.neobank.presentation.request.UserLoginRequest
import com.smart.neobank.presentation.response.UserLoginResponse
import org.mapstruct.Mapper

@Mapper
interface UserMapper {
    fun convertToEntity(userLoginRequest: UserLoginRequest): User
    fun convertToResponse(user: User): UserLoginResponse
}