package com.mytests.spring.springdatajpaqaenumskt.enumLiteralsInQueries

import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
class IssuesService(private val issuesRepository: IssuesRepository) {
    fun findByAuthors() {
        println("====== findByAuthors  =====")
        issuesRepository.findByAuthors()!!.forEach(Consumer { x: Issues? -> println(x) })
        println("===================")
    }

    fun findByPriorities() {
        println("====== findByPriorities  =====")
        issuesRepository.findByPriorities()!!.forEach(Consumer { x: Issues? -> println(x) })
        println("===================")
    }

    fun findByPrioritiesAsLiterals() {
        println("====== findByPrioritiesAsLiterals()  =====")
        issuesRepository.findByPrioritiesAsLiterals()!!.forEach(Consumer { x: Issues? -> println(x) })
        println("===================")
    }

    fun findByPrioritiesAsTypes() {
        println("====== findByPrioritiesAsTypes()  =====")
        issuesRepository.findByPrioritiesAsTypes()!!.forEach(Consumer { x: Issues? -> println(x) })
        println("===================")
    }

    fun findByPriority() {
        println("====== findByPriority()  =====")
        issuesRepository.findByPriority()!!.forEach(Consumer { x: Issues? -> println(x) })
        println("===================")
    }

    fun findByState() {
        println("====== findByState()  =====")
        issuesRepository.findByState(Issues.StateEnum.Open)!!.forEach(Consumer { x: Issues? -> println(x) })
        println("===================")
    }

    fun testNumEnumLiterals() {
        println("====== testNumEnumLiterals: enum fqn:  =====")
        issuesRepository.findByTypeAsNumEnumFQN()!!.forEach(Consumer { x: Issues? -> println(x) })
        println("====== testNumEnumLiterals: enum short name:  =====")
        issuesRepository.findByTypeAsNumEnumShortName()!!.forEach(Consumer { x: Issues? -> println(x) })
        println("====== testNumEnumLiterals: enum short names in IN:  =====")
        issuesRepository.findByTypeInAsNumEnumShortName()!!.forEach(Consumer { x: Issues? -> println(x) })
        println("====== testNumEnumLiterals: enum literal name:  =====")
        issuesRepository.findByTypeAsNumEnumLiteralName()!!.forEach(Consumer { x: Issues? -> println(x) })
        println("====== testNumEnumLiterals: enum literal names in IN:  =====")
        issuesRepository.findByTypeInAsNumEnumLiteralName()!!.forEach(Consumer { x: Issues? -> println(x) })
        println("====== testNumEnumLiterals: enum literal number:  =====")
        issuesRepository.findByTypeAsNumEnumLiteralNumber()!!.forEach(Consumer { x: Issues? -> println(x) })
        println("====== testNumEnumLiterals: enum literal numbers in IN:  =====")
        issuesRepository.findByTypeInAsNumEnumLiteralNumber()!!.forEach(Consumer { x: Issues? -> println(x) })

    }

    fun findByStatesAsInnerClassTypes() {
        println("====== findByStatesAsInnerClassTypes()  =====")
        issuesRepository.findByStatesAsInnerClassTypes()!!.forEach(Consumer { x: Issues? -> println(x) })
        println("===================")
    }

    fun toInnerDTOs(){
        println("====== toInnerDTOs()  ===")
        val dtos = issuesRepository.innerDtoAndInnerEnum();
        for (value in dtos) {
            println(value)
        }
    }
}
