package com.github.sawafrolov.creditfilter.services

import com.github.sawafrolov.creditfilter.dto.OrderCreateDto
import com.github.sawafrolov.creditfilter.dto.OrderDto
import com.github.sawafrolov.creditfilter.mappers.OrderMapper
import com.github.sawafrolov.creditfilter.repositories.OrderRepository
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
@RequiredArgsConstructor
class OrderServiceImpl(
    private val orderMapper: OrderMapper,
    private val orderRepository: OrderRepository,
    private val orderValidationService: OrderValidationService
): OrderService {

    override fun createOrder(orderCreateDto: OrderCreateDto): OrderDto {
        val checkStopFactorsResult = orderValidationService.checkStopFactors(orderCreateDto)
        if (checkStopFactorsResult.isRejected) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, checkStopFactorsResult.rejectReason)
        }

        val order = orderRepository.save(orderMapper.mapToDocument(orderCreateDto))
        return orderMapper.mapToDto(order)
    }
}
