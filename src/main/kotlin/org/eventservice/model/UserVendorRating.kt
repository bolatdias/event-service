package org.eventservice.model

import jakarta.persistence.*

@Table
@Entity
class UserVendorRating (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val rating: Double,
    val comment: String?=null,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,
    @ManyToOne
    @JoinColumn(name = "user_service_id", nullable = false)
    val userVendor: UserVendor,
)