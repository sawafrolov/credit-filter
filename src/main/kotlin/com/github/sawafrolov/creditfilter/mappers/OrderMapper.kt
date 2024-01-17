package com.github.sawafrolov.creditfilter.mappers

import com.github.sawafrolov.creditfilter.documents.Order
import com.github.sawafrolov.creditfilter.dto.OrderDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface OrderMapper {

    fun mapToDocument(orderDto: OrderDto): Order

    fun mapToDto(order: Order): OrderDto
}
