package com.habitly.habitly.model

import com.habitly.habitly.annotation.AllOpenAnnotation
import java.util.*
import javax.persistence.*

@Entity
@AllOpenAnnotation
@Table(name = "task")
class Task(
    var name: String,
    var dateCreated: Date,
    var dateDue: Date,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}