package org.eventservice.model

import jakarta.persistence.*


@Entity
@Table
class Place(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0,
    val title: String,
    val city: String?,
    val street: String?,
    val description: String?,

    @OneToMany(mappedBy = "place", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val halls: List<Hall> = listOf(),
    @OneToMany(mappedBy = "place", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val placeRatings: List<PlaceRating> = listOf(),
    @OneToMany(mappedBy = "place", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val images: List<Image> = listOf(),
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    val user: User
)