package org.eventservice.model

import jakarta.persistence.*

@Table
@Entity
class UserServiceRating (
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0,
    val rating: Double,
    val comment: String?=null,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,
    @ManyToOne
    @JoinColumn(name = "user_service_id", nullable = false)
    val userService: UserService,
)