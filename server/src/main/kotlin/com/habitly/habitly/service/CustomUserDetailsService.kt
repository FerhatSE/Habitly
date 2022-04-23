package com.habitly.habitly.service

import com.habitly.habitly.model.user.CustomUserDetails
import com.habitly.habitly.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        return CustomUserDetails(userRepository.findOneByUserName(username)!!)
    }
}