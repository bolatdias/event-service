package org.eventservice.model

import jakarta.persistence.*
import java.time.LocalDateTime


@Table
@Entity
class Hall (
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0,
    val title: String,
    val description: String? = null,
    val cost: Double? = null,
    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    var place: Place? = null,

    @OneToMany(mappedBy = "hall", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val halls: List<Event> = listOf(),
)