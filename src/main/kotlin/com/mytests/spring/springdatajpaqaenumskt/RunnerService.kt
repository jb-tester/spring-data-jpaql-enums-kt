package com.mytests.spring.springdatajpaqaenumskt

import com.mytests.spring.springdatajpaqaenumskt.enumLiteralsInQueries.IssuesService
import com.mytests.spring.springdatajpaqaenumskt.renameEnumLiteralUsedInConcatenation.FruitService
import com.mytests.spring.springdatajpaqaenumskt.useSingleEnumForEnumCollectionParameter.BasicService
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RunnerService {
    @Bean
    fun commandLineRunner(
        fruitService: FruitService,
        basicService: BasicService,
        issuesService: IssuesService
    ): CommandLineRunner {
        return CommandLineRunner { args: Array<String> ->
            println("--------------------------------------")
            fruitService.getFruitById()
            fruitService.fromType()
            fruitService.getFruitByType()
            println("--------------------------------------")
            basicService.displayBasicResults()
            println("--------------------------------------")
            issuesService.findByAuthors()
            issuesService.findByPriorities()
            issuesService.findByPrioritiesAsLiterals()
            issuesService.findByPrioritiesAsTypes()
            issuesService.findByPriority()
            issuesService.findByState()
            issuesService.findByStatesAsInnerClassTypes()
            issuesService.testNumEnumLiterals()
            issuesService.toInnerDTOs()
            println("--------------------------------------")
        }
    }
}
