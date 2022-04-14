package com.habitly.habitly.service

import com.habitly.habitly.model.User
import com.habitly.habitly.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun register(user: User): ResponseEntity<String> {
        return if (userRepository.findByUsername(user.userName) != null) {
            ResponseEntity(userRepository.save(user).toString(), HttpStatus.OK)
        } else {
            ResponseEntity("User with this name already exists", HttpStatus.NOT_ACCEPTABLE)
        }
    }

    fun login(username: String, password: String): ResponseEntity<String> {
        val user = userRepository.findByUsername(username)
            ?: return ResponseEntity("Invalid credentials, please try again.", HttpStatus.BAD_REQUEST)
        return if ((user.hashedPassword) == password) {
            ResponseEntity("Logged in successfully", HttpStatus.OK)
        } else {
            ResponseEntity("Invalid credentials, please try again.", HttpStatus.OK)
        }
    }

    fun logout() {

    }
}