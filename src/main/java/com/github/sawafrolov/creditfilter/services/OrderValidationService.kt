package com.github.sawafrolov.creditfilter.services

import com.github.sawafrolov.creditfilter.dto.Order

interface OrderValidationService {

    fun validateOrder(order: Order): Boolean
}