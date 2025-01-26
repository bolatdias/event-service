package org.eventservice.model

import jakarta.persistence.*

@Table
@Entity
class EventService(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0,
    val cost: Float,


    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    val event: Event,
    @ManyToOne
    @JoinColumn(name = "user_service_id", nullable = false)
    val userService: UserService
)