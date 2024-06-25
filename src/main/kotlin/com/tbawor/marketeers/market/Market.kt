package com.tbawor.marketeers.market

import com.tbawor.marketeers.agents.Agent
import com.tbawor.marketeers.agents.workers.Farmer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class Market {

    val logger: Logger = LoggerFactory.getLogger(Market::class.java)
    var tradeBook: TradeBook = TradeBook()

    val agents: MutableList<Agent> = mutableListOf(Farmer())

    fun runSimulation() {
        logger.info("Simulating market")
        runStep()
    }

    private fun runStep() {
        logger.info("Acting agents")
        agents.forEach { it.act() }
        logger.info("Creating asks and bids")
        agents.forEach { agent ->  tradeBook.asks.putAll(agent.createAsks().associateBy { it.commodity }) }
        agents.forEach { agent -> tradeBook.bids.putAll(agent.createBids().associateBy { it.commodity }) }
        logger.info("Matching asks and bids")

    }
}