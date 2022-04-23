package com.habitly.habitly.repository

import com.habitly.habitly.model.user.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findByUserName(username: String?): User?
    fun findOneByUserName(username: String?): User?
}