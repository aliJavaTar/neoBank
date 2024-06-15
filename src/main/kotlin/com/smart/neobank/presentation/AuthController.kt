package com.smart.neobank.presentation

import com.smart.neobank.infrastructure.security.service.AuthenticationService
import com.smart.neobank.presentation.request.AuthenticationRequest
import com.smart.neobank.presentation.response.AuthenticationResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authenticationService: AuthenticationService
) {
    @PostMapping
    fun authenticate(
        @RequestBody authRequest: AuthenticationRequest): AuthenticationResponse =
        authenticationService.authentication(authRequest)
}