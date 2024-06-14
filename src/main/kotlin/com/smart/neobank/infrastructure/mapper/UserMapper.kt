package com.smart.neobank.infrastructure.mapper

import com.smart.neobank.infrastructure.jpa.entity.User
import com.smart.neobank.presentation.request.UserLoginRequest
import org.mapstruct.Mapper

@Mapper
interface UserMapper {
    fun convertToEntity(userResponse: UserLoginRequest): User
}