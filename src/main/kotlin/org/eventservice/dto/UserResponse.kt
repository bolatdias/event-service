package org.eventservice.dto

import jakarta.persistence.*
import org.eventservice.model.*

class UserResponse(
    val username: String,
    @Column(unique = true)
    val email: String,
    val socialMedia: List<SocialMedia> = listOf()
)