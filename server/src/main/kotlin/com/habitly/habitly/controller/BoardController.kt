package com.habitly.habitly.controller

import com.habitly.habitly.service.BoardService
import org.springframework.stereotype.Controller

@Controller
class BoardController(
    val boardService: BoardService
) {

    fun save() {}
}

