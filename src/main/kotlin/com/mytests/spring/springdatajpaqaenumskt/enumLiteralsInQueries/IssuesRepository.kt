package com.mytests.spring.springdatajpaqaenumskt.enumLiteralsInQueries

import com.mytests.spring.springdatajpaqaenumskt.enumLiteralsInQueries.Issues.StateEnum
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface IssuesRepository : CrudRepository<Issues, Long> {
    // https://youtrack.jetbrains.com/issue/IDEA-160992
    @Query(value = "select * from enums.issues where state = :state", nativeQuery = true)
    fun findByState(@Param("state") state: StateEnum?): MutableList<Issues?>?

    // https://youtrack.jetbrains.com/issue/IDEA-379031/JPQL-enum-usage-without-package-shows-false-positive-syntax-error
    @Query("SELECT o FROM Issues o WHERE o.priority = 'High' OR o.priority = PriorityEnum.Medium")
    fun findByPriority(): MutableList<Issues?>?

    // https://youtrack.jetbrains.com/issue/IDEA-244155
    @Query("SELECT o FROM Issues o WHERE o.priority IN ('High', 'Medium')")
    fun findByPriorities(): MutableList<Issues?>?

    @Query("SELECT o FROM Issues o WHERE o.priority = High")
    fun findByPrioritiesAsLiterals(): MutableList<Issues?>?

    // https://youtrack.jetbrains.com/issue/IDEA-80076
    @Query("SELECT o FROM Issues o WHERE o.priority IN (com.mytests.spring.springdatajpaqaenumskt.enumLiteralsInQueries.PriorityEnum.High, com.mytests.spring.springdatajpaqaenumskt.enumLiteralsInQueries.PriorityEnum.Medium)")
    fun findByPrioritiesAsTypes(): MutableList<Issues?>?

    // https://youtrack.jetbrains.com/issue/IDEA-232989
    @Query("select issue from Issues issue where issue.state=com.mytests.spring.springdatajpaqaenumskt.enumLiteralsInQueries.Issues\$StateEnum.Open")
    fun findByStatesAsInnerClassTypes(): MutableList<Issues?>?

    @Query("select issue from Issues issue where issue.type = com.mytests.spring.springdatajpaqaenumskt.enumLiteralsInQueries.TypeEnum.Performance")
    fun findByTypeAsNumEnumFQN(): MutableList<Issues?>?

    @Query("select issue from Issues issue where issue.type = TypeEnum.Performance")
    fun findByTypeAsNumEnumShortName(): MutableList<Issues?>?
    @Query("select issue from Issues issue where issue.type in (TypeEnum.Performance, TypeEnum.Bug)")
    fun findByTypeInAsNumEnumShortName(): MutableList<Issues?>?

    @Query("select issue from Issues issue where issue.type = Performance")
    fun findByTypeAsNumEnumLiteralName(): MutableList<Issues?>?
    @Query("select issue from Issues issue where issue.type in (Performance, Bug)")
    fun findByTypeInAsNumEnumLiteralName(): MutableList<Issues?>?

    @Query("select issue from Issues issue where issue.type = 2")
    fun findByTypeAsNumEnumLiteralNumber(): MutableList<Issues?>?
    // https://youtrack.jetbrains.com/issue/IDEA-383703/JPA-QA-correctly-treat-the-enum-literal-numbers-using-in-IN
    @Query("select issue from Issues issue where issue.type in (2, 0)")
    fun findByTypeInAsNumEnumLiteralNumber(): MutableList<Issues?>?

    // incorrect query: value is used instead of index
    // https://youtrack.jetbrains.com/issue/IDEA-383704/JPA-QL-no-errors-are-reported-if-the-enum-literal-that-uses-standard-mapping-is-referenced-by-value
   //  @Query("select issue from Issues issue where issue.type = 'Bug'")
   //  fun findByTypeAsNumEnumLiteralValue(): MutableList<Issues?>?

    // use static fields:
    @Query("select issue from Issues issue where issue.author = com.mytests.spring.springdatajpaqaenumskt.enumLiteralsInQueries.Issues.AUTHOR1")
    fun findByAuthors(): MutableList<Issues?>?

    @Query("select new com.mytests.spring.springdatajpaqaenumskt.enumLiteralsInQueries.Issues\$IssueDTO(i.title, i.description) " +
            "from Issues i where " +
            "i.state = com.mytests.spring.springdatajpaqaenumskt.enumLiteralsInQueries.Issues\$StateEnum.Open")
    fun innerDtoAndInnerEnum():MutableList<Issues.IssueDTO>
}
