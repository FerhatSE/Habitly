package com.habitly.habitly.repository

import com.habitly.habitly.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByUsername(username: String?): User?
    fun findOneByUsername(username: String?): User?
}