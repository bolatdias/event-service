package org.eventservice.dto

import jakarta.persistence.*
import org.eventservice.model.ServiceTypeEnum
import org.eventservice.model.User

class UserVendorResponse (
    val id: Long = 0,
    val title: String,
    val description: String?,
    val experience: String?,
    val averageCost: Float?,
    val serviceType: ServiceTypeEnum,
)