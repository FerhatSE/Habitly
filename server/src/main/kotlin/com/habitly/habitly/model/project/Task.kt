package com.habitly.habitly.model.project

import com.habitly.habitly.annotation.AllOpenAnnotation
import java.util.*
import javax.persistence.*

@Entity
@AllOpenAnnotation
class Task(
    var name: String,
    var dateCreated: Date,
    var dateDue: Date,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}