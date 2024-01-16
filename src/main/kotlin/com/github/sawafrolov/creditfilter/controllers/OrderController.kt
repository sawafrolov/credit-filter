package com.github.sawafrolov.creditfilter.controllers

import com.github.sawafrolov.creditfilter.dto.OrderDto
import com.github.sawafrolov.creditfilter.services.OrderValidationService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping(value = ["/api/v1/orders"])
@RequiredArgsConstructor
class OrderController(
    private val orderValidationService: OrderValidationService
) {

    @RequestMapping(method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(@RequestBody order: OrderDto): OrderDto {
        if (orderValidationService.hasStopFactors(order)) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
        return order
    }
}
