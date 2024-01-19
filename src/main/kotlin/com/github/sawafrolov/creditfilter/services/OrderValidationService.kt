package com.github.sawafrolov.creditfilter.services

import com.github.sawafrolov.creditfilter.dto.CheckStopFactorsResultDto
import com.github.sawafrolov.creditfilter.dto.OrderCreateDto

interface OrderValidationService {

    fun checkStopFactors(orderCreateDto: OrderCreateDto): CheckStopFactorsResultDto
}
