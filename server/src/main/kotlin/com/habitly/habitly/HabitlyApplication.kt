package com.habitly.habitly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = ["com.*"])
@EntityScan(basePackages = ["com.habitly.habitly.model"])
@SpringBootApplication
class HabitlyApplication

fun main(args: Array<String>) {
    runApplication<HabitlyApplication>(*args)
}





