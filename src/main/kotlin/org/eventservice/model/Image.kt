package org.eventservice.model

import jakarta.persistence.*


@Table
@Entity
class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,
    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    val place: Place,
    val url: String
)