package com.github.sawafrolov.creditfilter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CreditFilterApplication

fun main(args: Array<String>) {
    runApplication<CreditFilterApplication>(*args)
}
