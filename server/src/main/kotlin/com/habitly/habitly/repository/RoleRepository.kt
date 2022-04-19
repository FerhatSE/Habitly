package com.habitly.habitly.repository

import com.habitly.habitly.model.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {
    fun findByName(roleName: String): Role
}