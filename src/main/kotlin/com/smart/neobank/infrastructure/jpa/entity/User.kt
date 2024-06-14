package com.smart.neobank.infrastructure.jpa.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @Column(nullable = false, unique = true)
    var username: String,
    @Column(nullable = false)
    var password: String
)