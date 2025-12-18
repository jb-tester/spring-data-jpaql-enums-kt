package com.mytests.spring.springdatajpaqaenumskt.useSingleEnumForEnumCollectionParameter

import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "basic_entities", schema = "enums")
class BasicEntity {
    @Id
    @GeneratedValue
    var id: Long? = null

    @ElementCollection(targetClass = Test::class, fetch = jakarta.persistence.FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    var testSet: MutableSet<Test?> = HashSet<Test?>()

    enum class Test {
        A, B, C, D
    }

    override fun toString(): String {
        return "BasicEntity{" +
                "id=" + id +
                ", testSet=" + testSet +
                '}'
    }
}