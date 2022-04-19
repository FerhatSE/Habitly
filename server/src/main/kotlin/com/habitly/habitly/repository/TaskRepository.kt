package com.habitly.habitly.repository

import com.habitly.habitly.model.Role
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Role, Long> {
    fun findByName(name: String): String
}