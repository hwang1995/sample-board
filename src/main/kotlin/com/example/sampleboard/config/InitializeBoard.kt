package com.example.sampleboard.config

import com.example.sampleboard.domain.Board
import com.example.sampleboard.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration

@Configuration
class InitializeBoard @Autowired constructor(
    val boardRepository: BoardRepository
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        // 1. 게시판에 게시글좀 넣어둡시다.
        val listOfBoard: MutableList<Board> = mutableListOf()
        for (num in 1..100) {
            val newBoard = Board("안녕하세요 $num 번째 합니다.", "황성욱", "내용물 $num", "1234")
            listOfBoard.add(newBoard)
        }

        boardRepository.saveAll(listOfBoard)
    }

}




