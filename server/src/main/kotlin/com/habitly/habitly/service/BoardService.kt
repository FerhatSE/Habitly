package com.habitly.habitly.service

import com.habitly.habitly.model.Board
import com.habitly.habitly.model.TaskList
import org.springframework.stereotype.Service

interface BoardService {
    fun createBoard(title: String, description: String): Board

    fun createTaskList(id: Long, title: String): TaskList

    fun editBoard() {}

    fun editTaskList() {}
}