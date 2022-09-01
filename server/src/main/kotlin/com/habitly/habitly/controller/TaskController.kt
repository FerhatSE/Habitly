package com.habitly.habitly.controller

import com.habitly.habitly.service.TaskService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/task")
class TaskController(
    val taskService: TaskService,
) {
}