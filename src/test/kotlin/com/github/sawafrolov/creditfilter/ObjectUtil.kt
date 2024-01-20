package com.github.sawafrolov.creditfilter

import com.github.sawafrolov.creditfilter.documents.Order
import com.github.sawafrolov.creditfilter.dto.OrderCreateDto
import com.github.sawafrolov.creditfilter.dto.OrderDto
import java.math.BigDecimal

fun correctDto() = OrderCreateDto(
    "1212121212", 12, BigDecimal("123456789.10")
)

fun ipDto() = OrderCreateDto(
    "121212121212", 12, BigDecimal("123456789.10")
)

fun krasnoyarskDto() = OrderCreateDto(
    "1212121212", 24, BigDecimal("123456789.10")
)

fun capitalExactlyFiveMillionsDto() = OrderCreateDto(
    "1212121212", 123, BigDecimal("5000000.00")
)

fun capitalLessThanFiveMillionsDto() = OrderCreateDto(
    "1212121212", 123, BigDecimal("4500000.00")
)

fun nonResidentDto() = OrderCreateDto(
    "9909090909", 12, BigDecimal("123456789.10")
)

fun correctOrder() = Order(
    null, "1212121212", 12, BigDecimal("123456789.10")
)

fun correctOrderWithId() = Order(
    "Some_string_id", "1212121212", 12, BigDecimal("123456789.10")
)

fun correctOrderDto() = OrderDto(
    "Some_string_id", "1212121212", 12, BigDecimal("123456789.10")
)
