package com.habitly.habitly.service

import com.habitly.habitly.model.project.Project
import com.habitly.habitly.model.project.TaskList
import com.habitly.habitly.model.user.User
import com.habitly.habitly.repository.ProjectRepository
import com.habitly.habitly.util.UserUtil
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Transactional
@Service
class ProjectServiceImpl(
    val projectRepository: ProjectRepository,
    val userUtil: UserUtil
) : ProjectService {
    override fun getProjects(): List<Project> {
        return getUser().projects
    }

    override fun addProject(title: String, colorTheme: String, deadline: Date) {
        val project = Project(title, colorTheme, deadline)
        getUser().projects.add(project)
    }


    override fun createTaskList(id: Long, title: String): TaskList {
        val board = projectRepository.findById(id).get()
        val taskList = TaskList(title)

        board.taskLists.add(taskList)
        projectRepository.save(board)
        return taskList
    }

    override fun editProject(id: Long, project: Project): Project {
        return projectRepository.save(project)
    }

    override fun deleteProject(id: Long) {
        return projectRepository.deleteById(id)
    }

    override fun editTaskList() {
        super.editTaskList()
    }

    private fun getUser(): User {
        return userUtil.getUser()
    }
}