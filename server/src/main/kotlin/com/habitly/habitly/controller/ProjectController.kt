package com.habitly.habitly.controller

import com.habitly.habitly.model.project.Project
import com.habitly.habitly.model.user.CustomUserDetails
import com.habitly.habitly.repository.ProjectRepository
import com.habitly.habitly.service.CustomUserDetailsService
import com.habitly.habitly.service.ProjectService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/project")
class ProjectController(
    val projectService: ProjectService,
    val projectRepository: ProjectRepository,
    val customUserDetailsService: CustomUserDetailsService
) {

    @GetMapping
    fun getProjects(): ResponseEntity<List<Project>> {
        return ResponseEntity.of(Optional.of(projectService.getProjects()))
    }

    @PostMapping("/add")
    fun createProject(title: String, description: String): ResponseEntity<String> {
        if (projectRepository.findOneByTitle(title) != null) {
            return ResponseEntity<String>(
                "Project with title $title already exists",
                HttpStatus.BAD_REQUEST
            )
        }
        return ResponseEntity<String>(
            projectService.createProject(title, description, getUserID()).toString(),
            HttpStatus.OK
        )
    }

    @PatchMapping("/edit/{id}")
    fun editProject(@PathVariable id: Long, title: String, description: String): ResponseEntity<String> {
        val project = Project(title, description, getUserID())
        return ResponseEntity.ok(projectService.editProject(id, project).toString())
    }

    @PatchMapping("/delete{id}")
    fun deleteProject(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(projectService.deleteProject(id))
    }

    @PostMapping("/tasklist/add/{id}")
    fun createTaskList(@PathVariable id: Long, title: String): ResponseEntity<String> {
        val project = projectRepository.findById(id).get()

        if (project.taskLists.any { task -> task.title == title }) {
            return ResponseEntity<String>(
                "Task list with title $title already exists",
                HttpStatus.BAD_REQUEST
            )
        }
        return ResponseEntity<String>(
            projectService.createTaskList(id, title).toString(),
            HttpStatus.OK
        )
    }

    fun getUserID(): Long {
        val principal = SecurityContextHolder.getContext().authentication.principal
        val user = customUserDetailsService.loadUserByUsername(principal.toString()) as CustomUserDetails
        return user.id
    }
}

