package com.mytests.spring.springdatajpaqaenumskt.renameEnumLiteralUsedInConcatenation

import jakarta.persistence.Entity
import jakarta.persistence.Enumerated
import jakarta.persistence.EnumType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "fruits", schema = "enums")
class Fruit {
    @Id
    var id: Long? = null

    @Enumerated(EnumType.STRING)
    var type: FruitType? = null

    var quantity: Int? = null
    override fun toString(): String {
        return "Fruit(id=$id, type=$type, quantity=$quantity)"
    }


}
