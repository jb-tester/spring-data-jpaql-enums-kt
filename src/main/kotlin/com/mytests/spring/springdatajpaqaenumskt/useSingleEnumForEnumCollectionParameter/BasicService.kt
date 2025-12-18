package com.mytests.spring.springdatajpaqaenumskt.useSingleEnumForEnumCollectionParameter

import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
class BasicService(private val basicEntityRepo: BasicEntityRepo) {
    fun displayBasicResults() {
        println("====== BasicResults =====")
        basicEntityRepo.someQuery().forEach(Consumer { x: BasicResult? -> println(x) })
        println("===================")
    }
}
