package com.smart.neobank.presentation

import com.smart.neobank.infrastructure.security.service.AuthenticationService
import com.smart.neobank.presentation.request.AuthenticationRequest
import com.smart.neobank.presentation.request.RefreshTokenRequest
import com.smart.neobank.presentation.response.AuthenticationResponse
import com.smart.neobank.presentation.response.TokenResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/auth")
class AuthController(private val authenticationService: AuthenticationService) {
    @PostMapping("/user")
    fun authenticate(
        @RequestBody authRequest: AuthenticationRequest
    ): AuthenticationResponse =
        authenticationService.authentication(authRequest)

    @PostMapping("/refreshToken")
    fun refreshAccessToken(
        @RequestBody request: RefreshTokenRequest
    ): TokenResponse =
        authenticationService.refreshAccessToken(request.token)
            ?.mapToTokenResponse()
            ?: throw ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid refresh token.")

    private fun String.mapToTokenResponse(): TokenResponse =
        TokenResponse(
            token = this
        )
}