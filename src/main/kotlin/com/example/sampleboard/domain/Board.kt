package com.example.sampleboard.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Board TABLE
 * - boardNo (PK, Long) => 게시판 게시글의 시퀀스 번호
 * - boardTitle (String, Not Null) => 게시판 게시글의 제목
 * - boardAuthor (String, Not Null) => 게시판 게시글의 원작자
 * - boardContent (String, Not Null) => 게시판 게시글의 컨텐츠
 * - boardCreatedAt (LocalDateTime, Not Null) => 게시판 게시글의 생성일자
 * - boardPassword (String, Not Null) => 게시판 게시글의 비밀번호
 *
 * @since 2022.03.26
 * @author SUNG WOOK HWANG
 */
@Entity
data class Board(
    var boardTitle: String,
    var boardAuthor: String,
    var boardContent: String,
    @JsonIgnore var boardPassword: String,
    var boardCreatedAt: LocalDateTime? = LocalDateTime.now(),
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var boardNo: Long? = null
)
