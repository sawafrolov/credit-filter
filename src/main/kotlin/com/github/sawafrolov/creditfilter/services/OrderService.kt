package com.github.sawafrolov.creditfilter.services

import com.github.sawafrolov.creditfilter.dto.OrderDto

interface OrderService {

    fun createOrder(order: OrderDto): OrderDto
}