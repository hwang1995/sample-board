package com.example.sampleboard.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.nio.charset.Charset

@SpringBootTest
@AutoConfigureMockMvc
internal class BoardControllerTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    @Test
    fun `모든 게시판의 있는 게시글을 가져옵시다`() {
        mockMvc
            .perform(get("/board").contentType(MediaType.APPLICATION_JSON))
            .andDo { it -> println(it.response.getContentAsString(Charset.forName("UTF-8"))) }
    }

    @Test
    fun `해당하는 boardNo의 게시글을 가져옵니다 (성공)`() {
        // given
        val boardNo: Int = 1

        // when & then
        mockMvc
            .perform(get("/board/${boardNo}").contentType(MediaType.APPLICATION_JSON))
            .andDo { it -> println(it.response.getContentAsString(Charset.forName("UTF-8"))) }
            .andExpect(status().isOk)

    }

    @Test
    fun `해당하는 boardNo의 게시글을 가져옵니다 (실패)`() {
        // given
        val boardNo = 999999

        // when & then
        mockMvc
            .perform(get("/board/${boardNo}").contentType(MediaType.APPLICATION_JSON))
            .andDo { it -> println(it.response.getContentAsString(Charset.forName("UTF-8"))) }
            .andExpect(status().isNotFound)

    }
}