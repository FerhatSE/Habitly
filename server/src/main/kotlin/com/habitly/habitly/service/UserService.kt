package com.habitly.habitly.service

import Role
import com.habitly.habitly.model.User
import com.habitly.habitly.model.UserDTO
import com.habitly.habitly.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UserService(val userRepository: UserRepository, val passwordEncoder: BCryptPasswordEncoder) {

    fun save(userDTO: UserDTO): ResponseEntity<String> {
        val user = User(
            userDTO.username,
            userDTO.displayName,
            userDTO.email,
            passwordEncoder.encode(userDTO.password),
        )
        return if (userRepository.findByUsername(userDTO.username) != null) {
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

    private fun mapRolesToAuthorities(roles: Collection<Role>): Collection<GrantedAuthority?> {
        return roles
            .stream()
            .map { role -> SimpleGrantedAuthority(role.roleName) }
            .collect(Collectors.toList())
    }
}