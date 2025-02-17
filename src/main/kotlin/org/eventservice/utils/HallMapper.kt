package org.eventservice.utils


import org.eventservice.dto.EventRequest
import org.eventservice.dto.EventResponse
import org.eventservice.dto.HallResponse
import org.eventservice.model.Event
import org.eventservice.model.Hall

object HallMapper {
    fun mapToModel(request: EventRequest): Event {
        return Event(
            title = request.title,
            startedAt = request.startedAt,
            endedAt = request.endedAt,
            description = request.description
        )
    }

    fun mapToResponse(hall: Hall): HallResponse {
        return HallResponse(
            id = hall.id,
            title = hall.title,
            description = hall.description,
            cost = hall.cost,
        )
    }
}