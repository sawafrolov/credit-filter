package com.github.sawafrolov.creditfilter.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import org.hibernate.validator.constraints.Length
import org.springframework.validation.annotation.Validated
import java.math.BigDecimal

@Validated
data class OrderCreateDto(

    @field:NotBlank
    @field:Length(min = 10, max = 12)
    val inn: String,

    @field:NotNull
    @field:Positive
    val regionNumber: Int,

    @field:NotNull
    @field:Positive
    val capital: BigDecimal
)
