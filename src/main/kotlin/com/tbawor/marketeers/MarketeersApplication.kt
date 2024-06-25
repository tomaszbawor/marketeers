package com.tbawor.marketeers

import com.tbawor.marketeers.market.Market
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MarketeersApplication(val mark: Market) : CommandLineRunner {
    val logger: Logger = LoggerFactory.getLogger(MarketeersApplication::class.java)

    override fun run(vararg args: String?) {
        logger.info("Starting market simulation")
        mark.runSimulation()
    }
}

fun main(args: Array<String>) {
    runApplication<MarketeersApplication>(*args)
}
