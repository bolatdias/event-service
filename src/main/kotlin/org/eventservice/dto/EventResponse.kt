package org.eventservice.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.eventservice.model.EventVendor
import org.eventservice.model.User
import java.time.LocalDateTime

class EventResponse(
    val id: Long = 0,
    val title: String,
    val startedAt: LocalDateTime? = null,
    val endedAt: LocalDateTime? = null,
    val description: String? = null,
    var hall: HallResponse? = null,
    val eventServices: List<UserVendorResponse> = listOf(),
)