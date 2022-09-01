package com.habitly.habitly.model.project

import com.habitly.habitly.annotation.AllOpenAnnotation
import javax.persistence.*

@Entity
@AllOpenAnnotation
@Table(name = "user_project")
data class Project(
    var title: String,
    var description: String,
    var userID: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var taskLists: MutableList<TaskList> = mutableListOf()

    var imageURL: String = ""
}