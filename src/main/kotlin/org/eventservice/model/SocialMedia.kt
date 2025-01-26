package org.eventservice.model

import jakarta.persistence.*


@Table
@Entity
class SocialMedia(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0,
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,
    val url: String,
    val socialMediaType: SocialMediaType
)

enum class SocialMediaType {
    WHATS_UP,
    TELEGRAM,
    INSTAGRAM,
    OTHERS
}