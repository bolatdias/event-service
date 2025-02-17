package org.eventservice.utils

import org.eventservice.dto.EventRequest
import org.eventservice.dto.EventResponse
import org.eventservice.dto.PlaceResponse
import org.eventservice.dto.UserResponse
import org.eventservice.model.Event
import org.eventservice.model.Place
import org.eventservice.model.User

object PlaceMapper {
    fun mapToModel(request: EventRequest): Event {
        return Event(
            title = request.title,
            startedAt = request.startedAt,
            endedAt = request.endedAt,
            description = request.description
        )
    }

    fun mapToResponse(place: Place): PlaceResponse {
        return PlaceResponse(
            id = place.id,
            title = place.title,
            city = place.city,
            street = place.street,
            description = place.description,
        )
    }
}