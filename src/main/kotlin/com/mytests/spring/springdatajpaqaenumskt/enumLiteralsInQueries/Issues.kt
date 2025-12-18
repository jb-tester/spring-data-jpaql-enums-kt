package com.mytests.spring.springdatajpaqaenumskt.enumLiteralsInQueries

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "issues", schema = "enums")
class Issues {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Basic
    @Column(name = "title")
    var title: String? = null

    @Basic
    @Column(name = "author")
    var author: String? = null

    @Basic
    @Column(name = "description")
    var description: String? = null

    @Basic
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private var priority: PriorityEnum? = null

    @Basic
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private var state: StateEnum? = null

    @Basic
    @Column(name = "type")
    //@Enumerated
    private var type: TypeEnum? = null

    fun getPriority(): PriorityEnum {
        return priority!!
    }

    fun setPriority(priority: PriorityEnum) {
        this.priority = priority
    }


    fun getState(): StateEnum {
        return state!!
    }

    fun setState(state: StateEnum) {
        this.state = state
    }
    fun getType(): TypeEnum {
        return type!!
    }
    fun setType(type: TypeEnum) {
        this.type = type
    }

    override fun toString(): String {
        return "Issues{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority!!.name +
                ", state=" + state!!.name +
                ", type=" + type!!.name +
                '}'
    }

    enum class StateEnum {
        Open, Closed
    }
    data class IssueDTO(val title: String?, val descr: String?)

    companion object {
        const val PATTERN: String = "table"
        const val AUTHOR1: String = "irina"
        const val AUTHOR2: String = "ira"
    }
}
