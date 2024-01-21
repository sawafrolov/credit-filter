package com.github.sawafrolov.creditfilter

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.sawafrolov.creditfilter.services.OrderService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class OrderControllerTest(
    @Autowired val mockMvc: MockMvc
) {

    @MockkBean
    lateinit var orderService: OrderService

    @Test
    fun testCorrect() {
        val correctDto = correctDto()
        val correctOrderDto = correctOrderDto()
        val objectMapper = jacksonObjectMapper()

        every {
            orderService.createOrder(correctDto)
        } returns correctOrderDto

        mockMvc.perform(
            post("/api/v1/orders")
                .content(objectMapper.writeValueAsString(correctDto))
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isCreated)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.inn").value(correctDto.inn))
            .andExpect(jsonPath("$.regionNumber").value(correctDto.regionNumber))
            .andExpect(jsonPath("$.capital").value(correctDto.capital))
    }
}
