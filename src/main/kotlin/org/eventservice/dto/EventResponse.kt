package org.eventservice.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.eventservice.model.EventVendor
import org.eventservice.model.User
import java.time.LocalDateTime

class EventResponse(
    val id: Long = 0,
    val title: String,
    @JsonProperty("started_at")
    val startedAt: LocalDateTime? = null,
    @JsonProperty("ended_at")
    val endedAt: LocalDateTime? = null,
    val description: String? = null,
    var place: PlaceResponse? = null,
    var user: User? = null,
    @JsonProperty("event_services")
    val eventServices: List<EventVendor> = listOf(),
)