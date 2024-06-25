package com.tbawor.marketeers.agents

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure
import com.tbawor.marketeers.Commodity

class Inventory(private val capacity: Int = DEFAULT_CAPACITY, private val items: MutableMap<Commodity, Int> = mutableMapOf()) {

    fun add(item: Commodity, amount: Int): Either<Error, Unit> = either {
        ensure(amount > 0) { Error("Amount must be greater than 0") }

        if (items.values.sum() + amount > capacity) {
            raise(Error("Not enough space in inventory"))
        }

        if (items.containsKey(item)) {
            items[item] = items[item]!! + amount
        } else {
            items[item] = amount
        }
    }

    fun remove(item: Commodity, amount: Int): Either<Error, Unit> = either {
        if (items.containsKey(item)) {
            items[item] = items[item]!! - amount
            if (items[item]!! <= 0) {
                items.remove(item)
            }
        } else {
            raise(Error("Item $item not found in inventory"))
        }
    }

    fun hasCommodity(commodity: Commodity, howMany: Int): Boolean {
        return (items[commodity] ?: 0) >= howMany
    }

    fun getCommodityAmount(commodity: Commodity): Int {
        return items[commodity] ?: 0
    }

    companion object {
        const val DEFAULT_CAPACITY = 50
    }
}