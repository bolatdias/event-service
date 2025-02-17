package org.eventservice.controller

import org.eventservice.dto.EventRequest
import org.eventservice.dto.EventResponse
import org.eventservice.model.Event
import org.eventservice.model.User
import org.eventservice.repository.UserRepository
import org.eventservice.security.CurrentUser
import org.eventservice.security.UserPrincipal
import org.eventservice.service.EventService
import org.eventservice.service.EventServiceImpl
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.security.access.annotation.Secured
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/event-service/event")
class EventController(
    private val eventService: EventService,
    private val userRepository: UserRepository
) {

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/create-event")
    fun createEvent(@RequestBody request: EventRequest, @CurrentUser currentUser: UserPrincipal): EventResponse {
        val user = userRepository.findById(currentUser.id).orElseThrow { RuntimeException("User not found") }
        return eventService.createEvent(request, user)
    }
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/update-event/{id}")
    fun updateEvent(@PathVariable id: Long, @RequestBody request: EventRequest, @CurrentUser currentUser: UserPrincipal): EventResponse {
        val user = userRepository.findById(currentUser.id).orElseThrow { RuntimeException("User not found") }
        return eventService.update(request, id, user)
    }
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @DeleteMapping("/delete-event/{id}")
    fun deleteEvent(@PathVariable id: Long): String {
        val user = userRepository.findById(2).orElseThrow { RuntimeException("User not found") }
        eventService.deleteEvent(id, user)
        return "Event deleted successfully"
    }

    @GetMapping("/get-event/{id}")
    fun getEvent(@PathVariable id: Long): EventResponse {
        return eventService.getEvent(id)
    }

    @GetMapping("/get-popular-events")
    fun getEvents(): List<EventResponse> {
        return eventService.getPopularEvents(10L)
    }

}
