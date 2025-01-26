package org.eventservice.controller

import org.eventservice.dto.EventRequest
import org.eventservice.model.Event
import org.eventservice.service.EventServiceImpl
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller
//
//@Compom
//class EventController(
//    private val eventService: EventServiceImpl
//) {
//
//    fun createEvent(@Argument request: EventRequest): Event {
//        return eventService.createEvent(request)
//    }
//
//    @MutationMapping
//    fun updateEvent(@Argument id: Long, @Argument request: EventRequest): Event {
//        return eventService.update(request, id)
//    }
//
//    @MutationMapping
//    fun updateEvent(@Argument id: Long): String {
//        eventService.deleteEvent(id)
//        return "Deleted event by id"
//    }
//
//}