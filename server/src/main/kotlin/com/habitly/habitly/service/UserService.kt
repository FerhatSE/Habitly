package com.habitly.habitly.service

import com.habitly.habitly.model.UserDTO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import javax.transaction.Transactional

interface UserService {
    fun save(userDTO: UserDTO): ResponseEntity<String>

    fun login(username: String, password: String): ResponseEntity<String>
}
