package org.eventservice.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    val userVendorRatings: List<UserVendorRating> = listOf(),

    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val places: List<Place> = listOf(),

    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val userVendor: List<UserVendor> = listOf(),

    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER)
    val socialMedia: List<SocialMedia> = listOf(),


    @ManyToMany
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    val roles: MutableSet<Role> = mutableSetOf()
)