package com.github.sawafrolov.creditfilter.services

import com.github.sawafrolov.creditfilter.dto.OrderDto
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
@RequiredArgsConstructor
class OrderServiceImpl(
    private val orderValidationService: OrderValidationService
): OrderService {

    override fun createOrder(order: OrderDto): OrderDto {
        val checkStopFactorsResult = orderValidationService.checkStopFactors(order)
        if (checkStopFactorsResult.isRejected) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, checkStopFactorsResult.rejectReason)
        }
        return order
    }
}
