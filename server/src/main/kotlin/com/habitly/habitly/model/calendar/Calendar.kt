package com.habitly.habitly.model.calendar

import com.habitly.habitly.annotation.AllOpenAnnotation
import com.habitly.habitly.model.project.TaskList
import javax.persistence.*

@Entity
@AllOpenAnnotation
data class Calendar(
    var userID: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var events: MutableList<Event> = mutableListOf()
}