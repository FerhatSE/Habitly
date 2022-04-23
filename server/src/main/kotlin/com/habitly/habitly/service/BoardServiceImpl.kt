package com.habitly.habitly.service

import com.habitly.habitly.model.Board
import com.habitly.habitly.model.TaskList
import com.habitly.habitly.repository.BoardRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class BoardServiceImpl(val boardRepository: BoardRepository) : BoardService {

    override fun createBoard(title: String, description: String): Board {
        val board = Board(title, description)
        return boardRepository.save(board)
    }

    override fun createTaskList(id: Long, title: String): TaskList {
        val board = boardRepository.findById(id).get()
        val taskList = TaskList(title)

        board.taskLists.add(taskList)
        boardRepository.save(board)
        return taskList
    }

    override fun editBoard() {
        super.editBoard()
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