package com.mytests.spring.springdatajpaqaenumskt.useSingleEnumForEnumCollectionParameter

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface BasicEntityRepo : CrudRepository<BasicEntity, Long> {
    // constructor error is shown - fixed
    @Query("select new com.mytests.spring.springdatajpaqaenumskt.useSingleEnumForEnumCollectionParameter.BasicResult(t.id, e) from BasicEntity t join t.testSet e")
    fun someQuery(): MutableList<BasicResult>

    // https://youtrack.jetbrains.com/issue/IDEA-383706/JPA-QA-false-errors-while-using-enum-element-collections
    @Query("select p from BasicEntity p where exists(select 1 from p.testSet c where c in('A', 'B'))")
    fun elementCollectionTest1(): MutableList<BasicEntity>

    // https://youtrack.jetbrains.com/issue/IDEA-383706/JPA-QA-false-errors-while-using-enum-element-collections
    @Query("select p from BasicEntity p " +
            "where exists(select 1 from p.testSet c where ((c = Test.A) " +
            "or (c = com.mytests.spring.springdatajpaqaenumskt.useSingleEnumForEnumCollectionParameter.BasicEntity\$Test.D)))")
    fun elementCollectionTest2(): MutableList<BasicEntity>
}
