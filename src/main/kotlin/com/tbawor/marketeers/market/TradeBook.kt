package com.tbawor.marketeers.market

import com.tbawor.marketeers.Commodity
import com.tbawor.marketeers.agents.Agent

class TradeBook {
    val asks: MutableMap<Commodity, Ask> = mutableMapOf()
    val bids: MutableMap<Commodity, Bid> = mutableMapOf()
}

sealed interface TradeOrder {
    val agent: Agent
    val commodity: Commodity
    val price: Double
    val quantity: Int
}

data class Bid(
    override val price: Double,
    override val quantity: Int,
    override val agent: Agent,
    override val commodity: Commodity
):TradeOrder

data class Ask(
    override val price: Double,
    override val quantity: Int,
    override val agent: Agent,
    override val commodity: Commodity,
): TradeOrder