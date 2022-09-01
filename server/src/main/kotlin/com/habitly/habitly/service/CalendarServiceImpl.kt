package com.habitly.habitly.service

import com.habitly.habitly.model.calendar.Calendar
import com.habitly.habitly.model.calendar.Event
import com.habitly.habitly.repository.CalendarRepository

class CalendarServiceImpl(
    private val calendarRepository: CalendarRepository
) : CalendarService {

    override fun getCalendar(): Calendar {
        return calendarRepository.findAll().first()
    }

    override fun addEvent(event: Event) {
        val calendar = getCalendar()
        calendar.events.add(event)
    }

    override fun editEvent(event: Event, id: Int) {
        val calendar = getCalendar()
        calendar.events[id] = event
    }

    override fun removeEvent(index: Int) {
        val calendar = getCalendar()
        calendar.events.removeAt(index)
    }

    override fun addLabel(color: String) {
        TODO("Not yet implemented")
    }

    override fun removeLabel(index: Number) {
        TODO("Not yet implemented")
    }
}