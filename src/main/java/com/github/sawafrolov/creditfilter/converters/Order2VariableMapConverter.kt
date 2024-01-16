package com.github.sawafrolov.creditfilter.converters

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.sawafrolov.creditfilter.dto.Order
import org.camunda.bpm.engine.variable.VariableMap
import org.camunda.bpm.engine.variable.Variables
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class Order2VariableMapConverter: Converter<Order, VariableMap> {

    override fun convert(source: Order): VariableMap? {
        return Variables.fromMap(
            jacksonObjectMapper()
                .convertValue(source, Map::class.java)
                    as Map<String, Any>
        )
    }
}