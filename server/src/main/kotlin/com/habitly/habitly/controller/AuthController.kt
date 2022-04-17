package com.habitly.habitly.controller

import com.habitly.habitly.model.UserDTO
import com.habitly.habitly.repository.UserRepository
import com.habitly.habitly.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    val userService: UserService,
    val userRepository: UserRepository
) {

    @GetMapping("/register")
    fun register(@ModelAttribute("user") userDTO: UserDTO): ResponseEntity<String> {
        if (userRepository.findOneByUsername(userDTO.username) == null) {
            return ResponseEntity<String>(
                "User with username ${userDTO.username} already exists",
                HttpStatus.BAD_REQUEST
            )
        }
        userService.save(userDTO)
        return ResponseEntity<String>(
            "User has successfully registered",
            HttpStatus.OK
        )
    }

    @GetMapping("login")
    fun login(): String {
        return ""
    }
}