package org.eventservice.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Table(name = "event_service")
@Entity
class EventVendor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val cost: Float,


    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    val event: Event,
    @ManyToOne
    @JoinColumn(name = "user_service_id", nullable = false)
    val userVendor: UserVendor
)