package com.github.sawafrolov.creditfilter.mappers

import com.github.sawafrolov.creditfilter.documents.Order
import com.github.sawafrolov.creditfilter.dto.OrderCreateDto
import com.github.sawafrolov.creditfilter.dto.OrderDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingConstants
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface OrderMapper {

    fun mapToDocument(orderCreateDto: OrderCreateDto): Order

    @Mapping(source = "order_id", target = "orderId")
    fun mapToDto(order: Order): OrderDto
}
