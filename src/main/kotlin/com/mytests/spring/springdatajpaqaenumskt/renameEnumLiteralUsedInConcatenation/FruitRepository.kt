package com.mytests.spring.springdatajpaqaenumskt.renameEnumLiteralUsedInConcatenation

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface FruitRepository : CrudRepository<Fruit, Long> {
    // rename APPLE to APPLE<any_suffix> to reproduce the issue
   @Query(
       "SELECT f FROM Fruit f "
               + "WHERE f.id = :id "
               + "     AND (f.type = com.mytests.spring.springdatajpaqaenumskt.renameEnumLiteralUsedInConcatenation.FruitType.Apple"
               + "     OR f.type =  com.mytests.spring.springdatajpaqaenumskt.renameEnumLiteralUsedInConcatenation.FruitType.Peach)"
   )
   fun fromId(@Param("id") id: Long?): Fruit?

   @Query("SELECT f FROM Fruit f WHERE f.type = Orange OR f.type = Peach")
   fun fromType(): List<Fruit?>

    fun getByType(type: FruitType): List<Fruit?>
}
