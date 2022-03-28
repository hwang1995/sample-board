package com.example.sampleboard.controller

import com.example.sampleboard.domain.Board
import com.example.sampleboard.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

/**
 * SearchController는 다음과 같은 API를 Expose한다.
 * - GET /search/board [게시판의 게시글 제목, 원작자를 기반으로 글을 가져옵니다.]
 */
@RestController
@RequestMapping("/search")
class SearchController @Autowired constructor(
    val boardRepository: BoardRepository
) {
    @GetMapping("/board")
    fun searchBoardByKeywordAndType(
        @RequestParam(name = "type", defaultValue = "title") type: String,
        @RequestParam(name = "keyword") keyword: String
    ): List<Board?> {
        return if (type.equals("title")) {
            boardRepository.findByBoardTitleContains(keyword)
        } else if (type.equals("author")) {
            boardRepository.findByBoardAuthorContains(keyword)
        } else {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "Can't found board this keyword = $keyword , type = $type"
            )
        }
    }
}