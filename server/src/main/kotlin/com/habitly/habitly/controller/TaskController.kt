package com.habitly.habitly.controller

import com.habitly.habitly.service.TaskService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/task")
class TaskController(
    val taskService: TaskService,
) {
}