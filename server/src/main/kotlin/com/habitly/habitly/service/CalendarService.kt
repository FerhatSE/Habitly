package com.habitly.habitly.service

import com.habitly.habitly.model.calendar.Calendar
import com.habitly.habitly.model.calendar.Event

interface CalendarService {
    fun getCalendar(): Calendar

    fun addEvent(event: Event)

    fun editEvent(event: Event, id: Int)

    fun removeEvent(index: Int)

    fun addLabel(color: String)

    fun removeLabel(index: Number)
}