package com.tbawor.marketeers.agents

import com.tbawor.marketeers.market.Ask
import com.tbawor.marketeers.market.Bid

interface Agent {

    fun act();
    fun createAsks(): List<Ask>
    fun createBids(): List<Bid>


    companion object {
        const val INITIAL_MONEY = 100.0
        const val PENALITY_FOR_NOT_PRODUCE = 5.0
    }
}