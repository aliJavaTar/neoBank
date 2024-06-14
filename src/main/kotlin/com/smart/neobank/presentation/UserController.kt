package com.smart.neobank.presentation

import com.smart.neobank.domain.use_case.LoginUser
import com.smart.neobank.presentation.request.UserLoginRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(
    private val loginUser: LoginUser
) {
    @PostMapping
    fun create(@RequestBody userRequest: UserLoginRequest): ResponseEntity<UserLoginRequest> {
        var user = loginUser.register(userRequest)
        return ResponseEntity(user, HttpStatus.CREATED)
    }

}
