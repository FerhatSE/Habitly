package com.habitly.habitly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = ["com.*"])
@SpringBootApplication
class HabitlyApplication

fun main(args: Array<String>) {
    runApplication<HabitlyApplication>(*args)
}


