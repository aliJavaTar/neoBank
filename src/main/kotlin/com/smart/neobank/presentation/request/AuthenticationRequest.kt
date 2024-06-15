package com.smart.neobank.presentation.request

data class AuthenticationRequest(
    val username: String,
    val password: String,
)