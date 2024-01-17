package com.github.sawafrolov.creditfilter.repositories

import com.github.sawafrolov.creditfilter.documents.Order
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: ElasticsearchRepository<Order, String> {
}
