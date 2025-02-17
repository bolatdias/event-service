package org.eventservice.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime


@JsonIgnoreProperties(ignoreUnknown = true)
data class EventRequest(
    val title: String,
    val startedAt: LocalDateTime? = null,
    val endedAt: LocalDateTime? = null,
    val description: String? = null,
    val hallId: Long,
    val eventServices: List<EventServiceRequest> = emptyList()
)

class EventServiceRequest(
    val id: Long
)