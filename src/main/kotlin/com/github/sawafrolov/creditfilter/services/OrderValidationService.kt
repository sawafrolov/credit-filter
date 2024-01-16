package com.github.sawafrolov.creditfilter.services

import com.github.sawafrolov.creditfilter.dto.CheckStopFactorsResultDto
import com.github.sawafrolov.creditfilter.dto.OrderDto

interface OrderValidationService {

    fun checkStopFactors(order: OrderDto): CheckStopFactorsResultDto
}