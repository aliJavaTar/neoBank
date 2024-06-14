package com.smart.neobank.infrastructure.jpa

import com.smart.neobank.infrastructure.jpa.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Int> {}