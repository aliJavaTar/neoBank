package com.smart.neobank.infrastructure.mapper

import com.smart.neobank.infrastructure.jpa.entity.UserEntity
import com.smart.neobank.presentation.request.UserLoginRequest
import com.smart.neobank.presentation.response.UserLoginResponse
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserMapper {
    fun convertToEntity(userLoginRequest: UserLoginRequest): UserEntity
    fun convertToResponse(user: UserEntity): UserLoginResponse
}