package com.habitly.habitly.service

import com.habitly.habitly.dto.RegistrationDTO
import org.springframework.http.ResponseEntity

interface UserService {
    fun save(registrationDTO: RegistrationDTO): ResponseEntity<String>

    fun login(username: String, password: String): ResponseEntity<String>
}
