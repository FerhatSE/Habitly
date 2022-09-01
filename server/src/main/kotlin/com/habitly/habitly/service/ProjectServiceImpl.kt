package com.habitly.habitly.service

import com.habitly.habitly.model.project.Project
import com.habitly.habitly.model.project.TaskList
import com.habitly.habitly.repository.ProjectRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class ProjectServiceImpl(val projectRepository: ProjectRepository) : ProjectService {
    override fun getProjects(): List<Project> {
        return projectRepository.findAll().toList()
    }

    override fun createProject(title: String, description: String, userID: Long): Project {
        val board = Project(title, description, userID)
        return projectRepository.save(board)
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

    /* Choose one of the available preset backgrounds
           Preferably the least used one
         */
    private fun setBackgroundImage() {

    }
}