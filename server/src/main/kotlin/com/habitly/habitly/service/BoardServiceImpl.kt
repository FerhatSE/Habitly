package com.habitly.habitly.service

import com.habitly.habitly.repository.BoardRepository

class BoardServiceImpl(val boardRepository: BoardRepository) : BoardService {

    override fun createBoard(title: String) {
        super.createBoard(title)
    }

    override fun createList(title: String) {
        super.createList(title)
    }

    override fun edit() {
        super.edit()
    }

    /* Choose one of the available preset backgrounds
       Preferably the least used one
     */
    private fun setBackgroundImage() {

    }
}