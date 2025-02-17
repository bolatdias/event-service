package org.eventservice.model

import jakarta.persistence.*


@Table
@Entity
class HallImage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    val hall: Hall,
    val url: String
)