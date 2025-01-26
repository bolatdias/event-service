package org.eventservice.dto

import org.eventservice.model.Event
import org.eventservice.model.Image
import org.eventservice.model.User

class PlaceResponse(
    val id: Long = 0,
    val title: String,
    val city: String?,
    val street: String?,
    val description: String?,
    val events: List<Event> = listOf(),
    val images: List<Image> = listOf(),
    val user: User
)