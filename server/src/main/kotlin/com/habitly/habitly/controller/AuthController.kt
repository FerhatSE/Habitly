package com.habitly.habitly.controller

import com.habitly.habitly.repository.UserRepository
import com.habitly.habitly.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    val userRepository: UserRepository,
    val userService: UserService
) {

    @GetMapping("test")
    fun login(): String {

        return ""
    }
}