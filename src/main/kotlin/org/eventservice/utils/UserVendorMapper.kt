package org.eventservice.utils


import org.eventservice.dto.EventRequest
import org.eventservice.dto.EventResponse
import org.eventservice.dto.HallResponse
import org.eventservice.dto.UserVendorResponse
import org.eventservice.model.Event
import org.eventservice.model.Hall
import org.eventservice.model.UserVendor

object UserVendorMapper {
    fun mapToModel(request: EventRequest): Event {
        return Event(
            title = request.title,
            startedAt = request.startedAt,
            endedAt = request.endedAt,
            description = request.description
        )
    }

    fun mapToResponse(userVendor: UserVendor): UserVendorResponse {
        return UserVendorResponse(
            id = userVendor.id,
            title = userVendor.title,
            description = userVendor.description,
            experience = userVendor.experience,
            averageCost = userVendor.averageCost,
            serviceType = userVendor.serviceType
        )
    }
}