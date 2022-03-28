package com.example.sampleboard.repository

import com.example.sampleboard.domain.Board
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * BoardRepository => 게시판 게시글을 가져오기 위한 레포지토리
 * - findByBoardTitleContains (boardTitle : String) => [LIKE 검색] 게시판의 게시글의 제목으로 Board를 가져오기
 * - findByBoardAuthorContains (boardAuthor : String) => [LIKE 검색] 게시판의 게시글의 원작자로 Board를 가져오기
 * - findByBoardTitle (boardTitle : String) => [정확히 입력, LIKE 검색 X] 게시판 게시글의 제목으로 Board를 가져오기
 * - findByBoardAuthor (boardAuthor : String) => [정확히 입력, LIKE 검색 X] 게시판 게시글의 원작자로 Board를 가져오기
 *
 * @since 2022.03.26
 * @author SUNG WOOK HWANG
 */
interface BoardRepository : PagingAndSortingRepository<Board, Long> {
    fun findByBoardTitleContains(boardTitle: String): List<Board?>
    fun findByBoardAuthorContains(boardAuthor: String): List<Board?>
    fun findByBoardTitle(boardTitle: String): Board?
    fun findByBoardAuthor(boardAuthor: String): Board?
}