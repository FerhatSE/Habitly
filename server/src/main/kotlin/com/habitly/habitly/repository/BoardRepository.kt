package com.habitly.habitly.repository

import com.habitly.habitly.model.Board
import org.springframework.data.repository.CrudRepository

interface BoardRepository : CrudRepository<Board, Long> {
    fun findOneByTitle(name: String): Board
}