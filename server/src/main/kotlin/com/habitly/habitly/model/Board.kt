package com.habitly.habitly.model

import com.habitly.habitly.annotation.AllOpenAnnotation
import javax.persistence.*

@Entity
@AllOpenAnnotation
@Table(name = "board")
class Board(
    var title: String,
    var description: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var lists: MutableList<List> = mutableListOf()

    lateinit var imageURL: String
}