package com.github.sawafrolov.creditfilter.services

import com.github.sawafrolov.creditfilter.dto.CheckStopFactorsResultDto
import com.github.sawafrolov.creditfilter.dto.OrderDto
import lombok.RequiredArgsConstructor
import org.camunda.bpm.dmn.engine.DmnDecision
import org.camunda.bpm.dmn.engine.DmnEngine
import org.camunda.bpm.engine.variable.VariableMap
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrderValidationServiceImpl(
    private val dmnEngine: DmnEngine,
    private val dmnDecision: DmnDecision,
    private val orderDto2VariableMapConverter: Converter<OrderDto, VariableMap>
): OrderValidationService {

    override fun checkStopFactors(orderDto: OrderDto): CheckStopFactorsResultDto {
        val variables = orderDto2VariableMapConverter.convert(orderDto)
        val result = dmnEngine
            .evaluateDecisionTable(dmnDecision, variables)
            .singleResult
            .entryMap

        return CheckStopFactorsResultDto(
            result["isRejected"] as Boolean,
            result["rejectReason"] as String
        )
    }
}
