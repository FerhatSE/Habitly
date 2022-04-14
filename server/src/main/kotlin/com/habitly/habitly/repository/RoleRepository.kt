package com.habitly.habitly.repository

import Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {
    fun findByRoleName(roleName: String): Role
}