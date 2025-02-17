package org.eventservice.dto

import org.eventservice.model.Event
import org.eventservice.model.HallImage

class PlaceResponse(
    val id: Long = 0,
    val title: String,
    val city: String?,
    val street: String?,
    val description: String?,
)