package com.mytests.spring.springdatajpaqaenumskt.useSingleEnumForEnumCollectionParameter

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface BasicEntityRepo : CrudRepository<BasicEntity, Long> {
    // constructor error is shown
    @Query("select new com.mytests.spring.springdatajpaqaenumskt.useSingleEnumForEnumCollectionParameter.BasicResult(t.id, e) from BasicEntity t join t.testSet e")
    fun someQuery(): MutableList<BasicResult>
}
