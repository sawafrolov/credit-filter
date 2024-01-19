package com.github.sawafrolov.creditfilter.documents

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.math.BigDecimal

@Document(indexName = "orders")
data class Order(

    @Id
    private val orderId: String,

    @Field(type = FieldType.Text, name = "inn")
    private val inn: String,

    @Field(type = FieldType.Integer, name = "region_number")
    private val regionNumber: Int,

    @Field(type = FieldType.Double, name = "capital")
    private val capital: BigDecimal
)
