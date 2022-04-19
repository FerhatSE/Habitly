package com.habitly.habitly.model

import javax.persistence.*

@Entity
@Table(name = "role")
data class Role(
    val name: String = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}
