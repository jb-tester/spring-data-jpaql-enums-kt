package com.mytests.spring.springdatajpaqaenumskt.renameEnumLiteralUsedInConcatenation

import org.springframework.stereotype.Service


@Service
class FruitService(private val fruitRepository: FruitRepository) {

    fun getFruitById() {
        println("-- fruits by id and type constants:--")
        println(fruitRepository.fromId(1L))
    }
    fun fromType() {
        println("-- fruits by type constants:--")
        println(fruitRepository.fromType())
    }
    fun getFruitByType() {
        println("-- fruits by type as parameter:--")
        println(fruitRepository.getByType(FruitType.Apple))
    }
}
