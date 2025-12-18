package com.mytests.spring.springdatajpaqaenumskt.useSingleEnumForEnumCollectionParameter

import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
class BasicService(private val basicEntityRepo: BasicEntityRepo) {
    fun displayBasicResults() {
        println("====== BasicResults =====")
        basicEntityRepo.someQuery().forEach(Consumer { x: BasicResult? -> println(x) })
    }
    fun useElementCollectionEnums(){
        println("====== ElementCollectionEnums: use literal value =====")
        basicEntityRepo.elementCollectionTest1().forEach(Consumer { x: BasicEntity? -> println(x) })
        println("====== ElementCollectionEnums: use enum fqn and short name =====")
        basicEntityRepo.elementCollectionTest2().forEach(Consumer { x: BasicEntity? -> println(x) })
    }
}
