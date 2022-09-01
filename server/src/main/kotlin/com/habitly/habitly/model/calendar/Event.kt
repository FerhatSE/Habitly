package com.habitly.habitly.model.calendar

import com.habitly.habitly.annotation.AllOpenAnnotation
import java.awt.Label
import java.util.*
import javax.persistence.*

@Entity
@AllOpenAnnotation
@Table(name = "event")
class Event(
    var name: String,
    var description: String,
    var dateCreated: Date,
    var dateDue: Date,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}