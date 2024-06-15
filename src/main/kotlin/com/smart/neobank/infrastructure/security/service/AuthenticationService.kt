package com.smart.neobank.infrastructure.security.service

import com.smart.neobank.infrastructure.security.model.JwtProperties
import com.smart.neobank.presentation.request.AuthenticationRequest
import com.smart.neobank.presentation.request.UserLoginRequest
import com.smart.neobank.presentation.response.AuthenticationResponse
import com.smart.neobank.presentation.response.UserLoginResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*

@Service
    class AuthenticationService(
    private val authManager: AuthenticationManager,
    private val userDetailsService: CustomUserDetailsService,
    private val tokenService: TokenService,
    private val jwtProperties: JwtProperties,
    ) {
        fun authentication(authRequest: AuthenticationRequest): AuthenticationResponse {
            authManager.authenticate(
                UsernamePasswordAuthenticationToken(
                    authRequest.username,
                    authRequest.password
                )
            )
            val user = userDetailsService.loadUserByUsername(authRequest.username)
            val accessToken = createAccessToken(user)
            return AuthenticationResponse(
                accessToken = accessToken,
            )
        }
        private fun createAccessToken(user: UserDetails) = tokenService.generate(
            userDetails = user,
            expirationDate = getAccessTokenExpiration()
        )
        private fun getAccessTokenExpiration(): Date =
            Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)

    }