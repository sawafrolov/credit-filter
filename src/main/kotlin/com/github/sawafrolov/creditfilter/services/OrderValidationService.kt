package com.github.sawafrolov.creditfilter.services

import com.github.sawafrolov.creditfilter.dto.OrderDto

interface OrderValidationService {

    fun hasStopFactors(order: OrderDto): Boolean
}