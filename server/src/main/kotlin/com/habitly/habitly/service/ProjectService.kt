package com.habitly.habitly.service

import com.habitly.habitly.model.project.Project
import com.habitly.habitly.model.project.TaskList

interface ProjectService {
    fun getProjects(): List<Project>

    fun createProject(title: String, description: String, userID: Long): Project

    fun createTaskList(id: Long, title: String): TaskList

    fun editProject(id: Long, project: Project): Project

    fun deleteProject(id: Long)

    fun editTaskList() {}
}