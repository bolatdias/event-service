package org.eventservice.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0,
    val name: String,
    val username: String,

    @Column(unique = true)
    val email: String,
    var password: String,

    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val events: List<Event> = listOf(),
    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val placeRatings: List<PlaceRating> = listOf(),
    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val userServiceRatings: List<UserServiceRating> = listOf(),
    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val places: List<Place> = listOf(),
    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val userService: List<UserService> = listOf(),
    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val socialMedia: List<SocialMedia> = listOf(),
)