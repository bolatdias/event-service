package org.eventservice.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDateTime

@Table
@Entity
class Event(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String,
    val startedAt: LocalDateTime? = null,
    val endedAt: LocalDateTime? = null,
    val description: String? = null,


    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    var hall: Hall? = null,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null,

    @OneToMany(mappedBy = "event", cascade = [(CascadeType.ALL)])
    var eventServices: List<EventVendor> = listOf(),
)