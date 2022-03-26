package com.example.sampleboard.repository

import com.example.sampleboard.domain.Board
import org.springframework.data.repository.CrudRepository

/**
 * BoardRepository => 게시판 게시글을 가져오기 위한 레포지토리
 * - findByBoardTitle (boardTitle : String) => 게시판 게시글의 제목으로 Board를 가져오기
 * - findByBoardAuthor (boardAuthor : String) => 게시판 게시글의 원작자로 Board를 가져오기
 *
 * @since 2022.03.26
 * @author SUNG WOOK HWANG
 */
interface BoardRepository : CrudRepository<Board, Long> {
    fun findByBoardTitle(boardTitle : String): Board?
    fun findByBoardAuthor(boardAuthor : String) : Board?
}