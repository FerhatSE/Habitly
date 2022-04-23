package com.habitly.habitly.controller

import com.habitly.habitly.repository.BoardRepository
import com.habitly.habitly.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/board")
class BoardController(
    val boardService: BoardService,
    val boardRepository: BoardRepository
) {
    @PostMapping("/add")
    fun createBoard(title: String, description: String): ResponseEntity<String> {
        if (boardRepository.findOneByTitle(title) != null) {
            return ResponseEntity<String>(
                "Board with title $title already exists",
                HttpStatus.BAD_REQUEST
            )
        }
        return ResponseEntity<String>(
            boardService.createBoard(title, description).toString(),
            HttpStatus.OK
        )
    }

//    @PostMapping("/tasklist/add{id}")
//    fun createTaskList(@PathVariable id: Long, title: String): ResponseEntity<String> {
//        val board = boardRepository.findById(id).get()
//
//        if (board.taskLists.any { task -> task.title == title }) {
//            return ResponseEntity<String>(
//                "Task list with title $title already exists",
//                HttpStatus.BAD_REQUEST
//            )
//        }
//        return ResponseEntity<String>(
//            boardService.createTaskList(id, title).toString(),
//            HttpStatus.OK
//        )
//    }
}

