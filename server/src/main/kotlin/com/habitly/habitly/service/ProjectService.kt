package com.habitly.habitly.service

import com.habitly.habitly.model.project.Project
import com.habitly.habitly.model.project.TaskList
import java.util.*

interface ProjectService {
    fun getProjects(): List<Project>

    fun addProject(title: String, colorTheme: String, deadline: Date)

    fun createTaskList(id: Long, title: String): TaskList

    fun editProject(id: Long, project: Project): Project

    fun deleteProject(id: Long)

    fun editTaskList() {}
}