package com.habitly.habitly.service

import com.habitly.habitly.dto.RegistrationDTO
import com.habitly.habitly.model.Role
import com.habitly.habitly.model.user.User
import com.habitly.habitly.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import javax.transaction.Transactional

@Transactional
@Service
class UserServiceImpl(val userRepository: UserRepository, val passwordEncoder: BCryptPasswordEncoder) : UserService {

    override fun save(registrationDTO: RegistrationDTO): ResponseEntity<String> {
        val user = User(
            registrationDTO.username,
            registrationDTO.displayName,
            passwordEncoder.encode(registrationDTO.password),
            listOf(Role("ROLE_USER")) as MutableList<Role>
        )
        return if (userRepository.findByUserName(registrationDTO.username) == null) {
            ResponseEntity(userRepository.save(user).toString(), HttpStatus.OK)
        } else {
            ResponseEntity("User with this name already exists", HttpStatus.NOT_ACCEPTABLE)
        }
    }

    override fun login(username: String, password: String): ResponseEntity<String> {
        print(username)
        print(password)
        val user = userRepository.findByUserName(username)
            ?: return ResponseEntity("Invalid credentials, please try again.", HttpStatus.BAD_REQUEST)
        return if ((user.hashedPassword) == password) {
            ResponseEntity("Logged in successfully", HttpStatus.OK)
        } else {
            ResponseEntity("Invalid credentials, please try again.", HttpStatus.OK)
        }
    }
}