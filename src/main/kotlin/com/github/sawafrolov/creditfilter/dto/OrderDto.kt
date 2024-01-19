package com.github.sawafrolov.creditfilter.dto

import java.math.BigDecimal

data class OrderDto(
    val orderId: String,
    val inn: String,
    val regionNumber: Int,
    val capital: BigDecimal
)
