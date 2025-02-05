package org.eventservice.controller

import org.eventservice.dto.EventRequest
import org.eventservice.model.Event
import org.eventservice.model.User
import org.eventservice.repository.UserRepository
import org.eventservice.security.CurrentUser
import org.eventservice.security.UserPrincipal
import org.eventservice.service.EventServiceImpl
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController(
    private val eventService: EventServiceImpl,
    private val userRepository: UserRepository
) {

    @PostMapping("/create-event")
    fun createEvent(@RequestBody request: EventRequest, @CurrentUser currentUser: UserPrincipal): Event {
        val user = userRepository.findById(currentUser.id).orElseThrow { RuntimeException("User not found") }
        return eventService.createEvent(request, user)
    }

    @MutationMapping
    fun updateEvent(@Argument id: Long, @Argument request: EventRequest, @CurrentUser currentUser: UserPrincipal): Event {
        val user = userRepository.findById(currentUser.id).orElseThrow { RuntimeException("User not found") }
        return eventService.update(request, id, user)
    }

    @MutationMapping
    fun deleteEvent(@Argument id: Long, @CurrentUser currentUser: UserPrincipal): String {
        val user = userRepository.findById(currentUser.id).orElseThrow { RuntimeException("User not found") }
        eventService.deleteEvent(id, user)
        return "Deleted event by id"
    }

    @QueryMapping(name = "getCurrentUser")
    fun getCurrentUser(@CurrentUser currentUser: UserPrincipal): User {
        val string="1231"

        val user = userRepository.findById(currentUser.id).orElseThrow { RuntimeException("User not found") }
        return user
    }

}