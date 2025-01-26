package org.eventservice.utils


import org.eventservice.dto.EventRequest
import org.eventservice.dto.EventResponse
import org.eventservice.model.Event

object EventMapper {
    fun mapToModel(request: EventRequest): Event {
        return Event(
            title = request.title,
            startedAt = request.startedAt,
            endedAt = request.endedAt,
            description = request.description
        )
    }

    fun mapToResponse(event:Event): EventResponse {
        return EventResponse(
            title = event.title,
            startedAt = event.startedAt,
            endedAt = event.endedAt,
            description = event.description
        )
    }
}