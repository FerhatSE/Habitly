package com.habitly.habitly.model.project

import com.habitly.habitly.annotation.AllOpenAnnotation
import java.util.*
import javax.persistence.*

@Entity
@AllOpenAnnotation
class Project(
    var title: String,
    var colorTheme: String,
    var deadline: Date
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var taskLists: MutableList<TaskList> = mutableListOf()
}