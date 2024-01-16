package com.github.sawafrolov.creditfilter.dto

import java.math.BigDecimal

data class Order(
    val inn: String,
    val regionNumber: Int,
    val capital: BigDecimal
)
