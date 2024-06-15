package com.smart.neobank.infrastructure.jpa

import com.smart.neobank.infrastructure.jpa.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<UserEntity, Int> {
    fun findByUsername(username: String): UserEntity?
}