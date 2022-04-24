package com.habitly.habitly.controller

import com.habitly.habitly.dto.LoginDTO
import com.habitly.habitly.dto.RegistrationDTO
import com.habitly.habitly.dto.ResponseMessage
import com.habitly.habitly.model.user.User
import com.habitly.habitly.repository.UserRepository
import com.habitly.habitly.service.UserServiceImpl
import com.habitly.habitly.util.JwtTokenUtil
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    val userService: UserServiceImpl,
    val userRepository: UserRepository,
    val tokenUtil: JwtTokenUtil,
    val authenticationManager: AuthenticationManager
) {

    @PostMapping("/register")
    fun register(@ModelAttribute("register") registrationDTO: RegistrationDTO): ResponseEntity<Any> {
        if (userRepository.findOneByUserName(registrationDTO.username) != null) {
            return ResponseEntity.badRequest()
                .body(ResponseMessage("\"User with username " + "${registrationDTO.username} already exists\""))
        }
        userService.save(registrationDTO)
        return ResponseEntity.ok(ResponseMessage("User has successfully registered"))
    }

    @PostMapping("login")
    fun login(@ModelAttribute("login") loginDTO: LoginDTO): ResponseEntity<Any> {
        try {
            val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(loginDTO.username, loginDTO.password)
            )

            val user = authentication.principal as? User
                ?: return ResponseEntity.badRequest().body(ResponseMessage("User not found."))

            val jwt = JwtTokenUtil().generateAccessToken(user)

            return ResponseEntity.ok(jwt)
        } catch (exception: BadCredentialsException) {
            return ResponseEntity.badRequest().body(exception.message)
        }
    }
}