package org.eventservice.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime


@JsonIgnoreProperties(ignoreUnknown = true)
data class EventRequest(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("started_at")
    val startedAt: LocalDateTime? = null,
    @JsonProperty("ended_at")
    val endedAt: LocalDateTime? = null,
    @JsonProperty("description")
    val description: String? = null,
    @JsonProperty("hall_id")
    val hallId: Long,
    @JsonProperty("user_id")
    val userId: Long,

    @JsonProperty("event_services")
    val eventServices: List<EventServiceRequest> = emptyList()
)

class EventServiceRequest(
    @JsonProperty("id")
    val id: Long,
)