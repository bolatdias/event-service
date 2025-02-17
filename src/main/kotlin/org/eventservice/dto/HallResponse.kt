package org.eventservice.dto

class HallResponse(
    val id: Long = 0,
    val title: String,
    val description: String? = null,
    val cost: Double? = null,
    val placeInfoDto: PlaceInfoDto? = null,
)

class PlaceInfoDto(
    val id: Long = 0,
    val title: String,
    val city: String?,
    val street: String?,
    val description: String?,
)