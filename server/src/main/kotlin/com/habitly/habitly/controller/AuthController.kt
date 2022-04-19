package com.habitly.habitly.controller

import com.habitly.habitly.model.UserDTO
import com.habitly.habitly.repository.UserRepository
import com.habitly.habitly.service.UserServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional

@RestController
@RequestMapping("/auth")
class AuthController(
    val userService: UserServiceImpl,
    val userRepository: UserRepository
) {

    @PostMapping("/register")
    fun register(@ModelAttribute("user") userDTO: UserDTO): ResponseEntity<String> {
        if (userRepository.findOneByUserName(userDTO.username) != null) {
            print(userDTO.toString())
            return ResponseEntity<String>(
                "User with username ${userDTO.username} already exists",
                HttpStatus.BAD_REQUEST
            )
        }
        print(userService.save(userDTO).body)
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