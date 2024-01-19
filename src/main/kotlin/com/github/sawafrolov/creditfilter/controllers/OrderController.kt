package com.github.sawafrolov.creditfilter.controllers

import com.github.sawafrolov.creditfilter.dto.OrderCreateDto
import com.github.sawafrolov.creditfilter.dto.OrderDto
import com.github.sawafrolov.creditfilter.services.OrderService
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v1/orders"])
@RequiredArgsConstructor
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(@RequestBody @Valid orderCreateDto: OrderCreateDto): OrderDto {
        return orderService.createOrder(orderCreateDto)
    }
}
