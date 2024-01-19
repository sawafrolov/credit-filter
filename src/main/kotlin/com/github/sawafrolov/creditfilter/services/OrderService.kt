package com.github.sawafrolov.creditfilter.services

import com.github.sawafrolov.creditfilter.dto.OrderCreateDto
import com.github.sawafrolov.creditfilter.dto.OrderDto

interface OrderService {

    fun createOrder(orderCreateDto: OrderCreateDto): OrderDto
}
