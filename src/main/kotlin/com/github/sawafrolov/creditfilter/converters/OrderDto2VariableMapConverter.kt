package com.github.sawafrolov.creditfilter.converters

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.sawafrolov.creditfilter.dto.OrderDto
import org.camunda.bpm.engine.variable.VariableMap
import org.camunda.bpm.engine.variable.Variables
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class OrderDto2VariableMapConverter: Converter<OrderDto, VariableMap> {

    override fun convert(source: OrderDto): VariableMap? {
        return Variables.fromMap(
            jacksonObjectMapper()
                .convertValue(source, Map::class.java)
                    as Map<String, Any>
        )
    }
}
