package com.habitly.habitly.repository

import com.habitly.habitly.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<User, Long>