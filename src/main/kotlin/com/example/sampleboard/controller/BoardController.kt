package com.example.sampleboard.controller

import com.example.sampleboard.domain.Board
import com.example.sampleboard.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

/**
 * BoardController는 다음과 같은 API를 Expose한다.
 *
 * - GET /board [게시판의 있는 게시글을 모조리 가져옵니다. (Pagination X)]
 * - GET /board/{boardNo} [해당 boardNo에 속해있는 게시글을 가져옵니다.]
 * - POST /board [게시판의 게시글을 추가하기 위해 사용합니다.]
 * - PUT /board [게시판의 게시글을 수정하기 위해 사용합니다.]
 * - DELETE /board/{boardNo} [게시판의 게시글을 삭제하기 위해 사용합니다.]
 *
 * @since 2022.03.26
 * @author SUNG WOOK HWANG
 */
@RestController
@RequestMapping("/board")
class BoardController @Autowired constructor(
    val boardRepository: BoardRepository
) {
    @GetMapping("")
    fun getAllBoard(): List<Board> =
        boardRepository.findAll().toList().reversed()

    @GetMapping("/{boardNo}")
    fun getSpecificBoard(@PathVariable boardNo: Long): Board =
        boardRepository.findByIdOrNull(boardNo) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND, "Can't found board this boardNo = $boardNo"
        )

    @PostMapping("")
    fun saveBoard(@RequestBody board: Board): Long? = boardRepository.save(board).boardNo

    @PutMapping("")
    fun modifyBoard(@RequestBody board: Board): Long? = boardRepository.save(board).boardNo

    @DeleteMapping("/{boardNo}")
    fun deleteBoardByBoardNo(@PathVariable boardNo: Long): Unit = boardRepository.deleteById(boardNo)
}