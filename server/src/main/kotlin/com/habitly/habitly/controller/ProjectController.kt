package com.habitly.habitly.controller

import com.habitly.habitly.dto.ProjectDTO
import com.habitly.habitly.model.project.Project
import com.habitly.habitly.repository.ProjectRepository
import com.habitly.habitly.service.CustomUserDetailsService
import com.habitly.habitly.service.ProjectService
import com.habitly.habitly.util.UserUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/project")
class ProjectController(
    val projectService: ProjectService,
    val projectRepository: ProjectRepository,
) {

    @GetMapping()
    fun getProjects(request: HttpServletRequest): ResponseEntity<List<Project>> {
        return ResponseEntity.of(Optional.of(projectService.getProjects()))
    }

    @PostMapping("/add")
    fun createProject(
        @RequestBody project: ProjectDTO,
    ): ResponseEntity<String> {
        if (projectRepository.findOneByTitle(project.title) != null) {
            return ResponseEntity<String>(
                "Project with title $project.title already exists",
                HttpStatus.BAD_REQUEST
            )
        }
        return ResponseEntity<String>(
            projectService.addProject(project.title, project.colorTheme, project.deadline).toString(),
            HttpStatus.OK
        )
    }

    @PatchMapping("/edit/{id}")
    fun editProject(@PathVariable id: Long, title: String, colorTheme: String, deadline: Date): ResponseEntity<String> {
        val project = Project(title, colorTheme, deadline)
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
}

