package org.eventservice.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*


@Table
@Entity
class Hall (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String,
    val description: String? = null,
    val cost: Double? = null,


    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    var place: Place? = null,
    @OneToMany(mappedBy = "hall", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val images: List<HallImage> = listOf(),

    @OneToMany(mappedBy = "hall", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val events: List<Event> = listOf(),
)