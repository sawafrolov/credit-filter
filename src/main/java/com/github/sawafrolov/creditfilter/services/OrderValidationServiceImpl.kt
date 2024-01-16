package com.github.sawafrolov.creditfilter.services

import com.github.sawafrolov.creditfilter.dto.Order
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
    private val order2VariableMapConverter: Converter<Order, VariableMap>
): OrderValidationService {

    override fun validateOrder(order: Order): Boolean {
        val variables = order2VariableMapConverter.convert(order)
        val result = dmnEngine.evaluateDecisionTable(dmnDecision, variables)
        return result
            .singleResult
            .getSingleEntry()
    }
}