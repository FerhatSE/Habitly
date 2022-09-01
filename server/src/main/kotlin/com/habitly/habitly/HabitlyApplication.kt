package com.habitly.habitly

import com.habitly.habitly.filter.JwtTokenFilter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import javax.servlet.Filter

@ComponentScan(basePackages = ["com.*"])
@EntityScan(basePackages = ["com.habitly.habitly.model"])
@SpringBootApplication
class HabitlyApplication

fun main(args: Array<String>) {
    runApplication<HabitlyApplication>(*args)
}




