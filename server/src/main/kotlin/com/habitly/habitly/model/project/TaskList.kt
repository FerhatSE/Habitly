package com.habitly.habitly.model.project

import com.habitly.habitly.annotation.AllOpenAnnotation
import javax.persistence.*

@Entity
@AllOpenAnnotation
class TaskList(
    var title: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var tasks: MutableList<Task> = mutableListOf()
}