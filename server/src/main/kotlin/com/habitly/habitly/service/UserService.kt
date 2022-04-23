package com.habitly.habitly.service

import com.habitly.habitly.model.user.UserDTO
import org.springframework.http.ResponseEntity

interface UserService {
    fun save(userDTO: UserDTO): ResponseEntity<String>

    fun login(username: String, password: String): ResponseEntity<String>
}
