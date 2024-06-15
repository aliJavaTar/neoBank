package com.smart.neobank.presentation.response

data class AuthenticationResponse(
    val accessToken: String,
    val refreshToken: String,

    )