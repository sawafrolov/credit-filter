package com.github.sawafrolov.creditfilter.services

import com.github.sawafrolov.creditfilter.dto.Order

interface OrderValidationService {

    fun hasStopFactors(order: Order): Boolean
}