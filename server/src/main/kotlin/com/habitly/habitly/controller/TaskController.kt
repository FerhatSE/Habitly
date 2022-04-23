package com.habitly.habitly.controller

import com.habitly.habitly.service.TaskService
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/task")
class TaskController(
    val taskService: TaskService,
) {
}