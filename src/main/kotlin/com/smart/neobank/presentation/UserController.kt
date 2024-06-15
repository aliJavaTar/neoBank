package com.smart.neobank.presentation

import com.smart.neobank.domain.use_case.LoginUser
import com.smart.neobank.presentation.request.UserLoginRequest
import com.smart.neobank.presentation.response.UserLoginResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(private val loginUser: LoginUser) {

    @PostMapping("/register")
    fun create(@RequestBody userRequest: UserLoginRequest): ResponseEntity<UserLoginResponse> {
        return ResponseEntity.ok(loginUser.register(userRequest))
    }

}
