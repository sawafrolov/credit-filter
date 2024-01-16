package com.github.sawafrolov.creditfilter.configuration

import org.camunda.bpm.dmn.engine.DmnDecision
import org.camunda.bpm.dmn.engine.DmnEngine
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream

@Configuration
class CommonConfiguration {

    @Bean
    fun dmnEngine(): DmnEngine {
        return DmnEngineConfiguration
            .createDefaultDmnEngineConfiguration()
            .buildEngine()
    }

    @Bean
    fun dmnDecision(dmnEngine: DmnEngine): DmnDecision {
        FileInputStream("camunda/diagram.dmn").use {
            return dmnEngine.parseDecision("Decision_0ozg60u", it)
        }
    }
}
