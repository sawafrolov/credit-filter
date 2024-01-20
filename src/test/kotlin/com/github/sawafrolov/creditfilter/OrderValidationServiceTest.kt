package com.github.sawafrolov.creditfilter

import com.github.sawafrolov.creditfilter.services.OrderValidationService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OrderValidationServiceTest(
    @Autowired val orderValidationService: OrderValidationService
) {

    @Test
    @DisplayName("Проверка на корректном тестовом примере")
    fun testCorrect() {
        assertFalse(orderValidationService.checkStopFactors(correctDto()).isRejected)
    }

    @Test
    @DisplayName("Проверка на тестовом примере для ИП")
    fun testIp() {
        val result = orderValidationService.checkStopFactors(ipDto())
        assertTrue(result.isRejected)
        assertEquals("Не выдаем кредиты ИП", result.rejectReason)
    }

    @Test
    @DisplayName("Проверка на тестовом примере для Красноярского края")
    fun testKrasnoyarsk() {
        val result = orderValidationService.checkStopFactors(krasnoyarskDto())
        assertTrue(result.isRejected)
        assertEquals("Не выдаем кредиты компаниям из Красноярского края", result.rejectReason)
    }

    @Test
    @DisplayName("Проверка на тестовом примере для капитала ровно 5 миллионов рублей")
    fun testCapitalExactlyFiveMillions() {
        val result = orderValidationService.checkStopFactors(capitalExactlyFiveMillionsDto())
        assertFalse(result.isRejected)
    }

    @Test
    @DisplayName("Проверка на тестовом примере для капитала меньше 5 миллионов рублей")
    fun testCapitalLessThanFiveMillions() {
        val result = orderValidationService.checkStopFactors(capitalLessThanFiveMillionsDto())
        assertTrue(result.isRejected)
        assertEquals("Не выдаем кредиты компаниям с капиталом менее 5 миллионов рублей", result.rejectReason)
    }

    @Test
    @DisplayName("Проверка на тестовом примере для нерезидента РФ")
    fun testNonResident() {
        val result = orderValidationService.checkStopFactors(nonResidentDto())
        assertTrue(result.isRejected)
        assertEquals("Не выдаем кредиты нерезидентам РФ", result.rejectReason)
    }
}
