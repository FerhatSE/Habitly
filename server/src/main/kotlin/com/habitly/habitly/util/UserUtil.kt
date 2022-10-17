package com.habitly.habitly.util

import com.habitly.habitly.model.user.User
import com.habitly.habitly.repository.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class UserUtil(
    val userRepository: UserRepository
) {

    fun getUser(): User {
        val authentication = SecurityContextHolder.getContext().authentication
        return userRepository.findOneByUserName(authentication.name)!!
    }
}