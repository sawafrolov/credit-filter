package com.github.sawafrolov.creditfilter.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Positive
import org.springframework.validation.annotation.Validated
import java.math.BigDecimal

@Validated
data class OrderCreateDto(

    @field:NotBlank
    @field:Pattern(
        regexp = "^\\d{10}(\\d{2})?\$",
        message = "ИНН должен состоять из 10 или 12 цифр"
    )
    val inn: String,

    @field:NotNull
    @field:Positive
    val regionNumber: Int,

    @field:NotNull
    @field:Positive
    val capital: BigDecimal
)
