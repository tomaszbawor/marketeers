package com.tbawor.marketeers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MarketeersApplication : CommandLineRunner {
    val logger: Logger = LoggerFactory.getLogger(MarketeersApplication::class.java)

    override fun run(vararg args: String?) {
      logger.info("Hello from Marketeers application!")
    }

}

fun main(args: Array<String>) {
    runApplication<MarketeersApplication>(*args)
}
