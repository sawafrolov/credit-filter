package com.github.sawafrolov.creditfilter

import com.github.sawafrolov.creditfilter.dto.CheckStopFactorsResultDto
import com.github.sawafrolov.creditfilter.mappers.OrderMapper
import com.github.sawafrolov.creditfilter.repositories.OrderRepository
import com.github.sawafrolov.creditfilter.services.OrderService
import com.github.sawafrolov.creditfilter.services.OrderServiceImpl
import com.github.sawafrolov.creditfilter.services.OrderValidationService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.web.server.ResponseStatusException

class OrderServiceTest {

    private val orderMapper: OrderMapper = mockk()
    private val orderRepository: OrderRepository = mockk()
    private val orderValidationService: OrderValidationService = mockk()

    private val orderService: OrderService = OrderServiceImpl(orderMapper, orderRepository, orderValidationService)

    @Test
    @DisplayName("Проверка на корректном тестовом примере")
    fun testCorrect() {
        val correctDto = correctDto()
        val correctOrder = correctOrder()
        val correctOrderWithId = correctOrderWithId()
        val correctOrderDto = correctOrderDto()

        every {
            orderValidationService.checkStopFactors(correctDto)
        } returns CheckStopFactorsResultDto(false, "")

        every {
            orderMapper.mapToDocument(correctDto)
        } returns correctOrder

        every {
            orderRepository.save(correctOrder)
        } returns correctOrderWithId

        every {
            orderMapper.mapToDto(correctOrderWithId)
        } returns correctOrderDto

        assertEquals(correctOrderDto, orderService.createOrder(correctDto))
    }

    @Test
    @DisplayName("Проверка на тестовом примере для ИП")
    fun testIp() {
        val dto = ipDto()
        val message = "Не выдаем кредиты ИП"
        every {
            orderValidationService.checkStopFactors(dto)
        } returns CheckStopFactorsResultDto(true, message)
        assertThrows<ResponseStatusException> {
            orderService.createOrder(dto)
        }
    }
}
