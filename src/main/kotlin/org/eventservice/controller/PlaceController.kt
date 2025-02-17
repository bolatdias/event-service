package org.eventservice.controller

import org.eventservice.dto.EventRequest
import org.eventservice.dto.EventResponse
import org.eventservice.dto.PlaceResponse
import org.eventservice.dto.UserVendorResponse
import org.eventservice.model.Event
import org.eventservice.model.User
import org.eventservice.repository.UserRepository
import org.eventservice.security.CurrentUser
import org.eventservice.security.UserPrincipal
import org.eventservice.service.EventService
import org.eventservice.service.EventServiceImpl
import org.eventservice.service.PlaceService
import org.eventservice.service.UserVendorService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/event-service/place")
class PlaceController (
    private val placeService: PlaceService,
    private val userRepository: UserRepository
) {
    @GetMapping("/get-popular-vendors")
    fun getEvents(): List<PlaceResponse> {
        return placeService.getPopularPlaces(10L)
    }
}
