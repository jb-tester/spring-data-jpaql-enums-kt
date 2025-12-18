package com.mytests.spring.springdatajpaqaenumskt.useSingleEnumForEnumCollectionParameter

class BasicResult(val id: Long, val test: BasicEntity.Test?) {
    override fun toString(): String {
        return "BasicResult(id=$id, test=$test)"
    }
}