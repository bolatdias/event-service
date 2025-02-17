package org.eventservice.utils

import org.eventservice.dto.EventRequest
import org.eventservice.dto.EventResponse
import org.eventservice.dto.UserResponse
import org.eventservice.model.Event
import org.eventservice.model.User

object UserMapper {
    fun mapToModel(request: EventRequest): Event {
        return Event(
            title = request.title,
            startedAt = request.startedAt,
            endedAt = request.endedAt,
            description = request.description
        )
    }

    fun mapToResponse(user: User): UserResponse {
        return UserResponse(
            username = user.username,
            email = user.email,
            socialMedia = user.socialMedia
        )
    }
}