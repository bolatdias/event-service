package org.eventservice.model

import jakarta.persistence.*


@Table
@Entity
class PlaceRating (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val rating: Double,
    val comment: String?=null,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,
    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    val place: Place,
)