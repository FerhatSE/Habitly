package com.habitly.habitly.repository

import com.habitly.habitly.model.project.Project
import org.springframework.data.repository.CrudRepository

interface ProjectRepository : CrudRepository<Project, Long> {
    fun findOneByTitle(name: String): Project?
}