package com.tbawor.marketeers.agents.workers

import com.tbawor.marketeers.Commodity
import com.tbawor.marketeers.agents.Agent
import com.tbawor.marketeers.agents.Inventory
import com.tbawor.marketeers.market.Ask
import com.tbawor.marketeers.market.Bid
import org.slf4j.LoggerFactory

class Farmer: Agent {
    private val logger = LoggerFactory.getLogger(Farmer::class.java)

    private val inventory: Inventory = Inventory()
    private var money: Double = Agent.INITIAL_MONEY

    val IDEAL_INVENTORY_CONTENT: Map<Commodity, Int> = mapOf(
        Commodity.WOOD to 3,
    )

    override fun act() {
        if(inventory.hasCommodity(Commodity.WOOD, 1)) {
            inventory.remove(Commodity.WOOD, 1)
            inventory.add(Commodity.GRAIN, 2)
        } else {
            money -= Agent.PENALITY_FOR_NOT_PRODUCE
            logger.info("Farmer not produced anything, lost 10 money")
        }
    }

    override fun createAsks(): List<Ask> {
        logger.debug("Farmer creating asks")

        inventory.getCommodityAmount(Commodity.GRAIN)?.let {
            return listOf(Ask(1.0, it, this, Commodity.GRAIN))
        }
        return listOf()
    }

    override fun createBids(): List<Bid> {
        logger.debug("Farmer creating bids")
        return listOf()
    }
}