package com.habitly.habitly.repository

import com.habitly.habitly.model.calendar.Calendar
import org.springframework.data.repository.CrudRepository

interface CalendarRepository : CrudRepository<Calendar, Long>
