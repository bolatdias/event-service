package org.eventservice.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*


@Table
@Entity
class UserVendor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String,
    val description: String?,
    val experience: String?,
    val averageCost: Float?,
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    val user: User,
    @Enumerated(EnumType.STRING)
    val serviceType: ServiceTypeEnum,

    @JsonManagedReference
    @OneToMany(mappedBy = "userVendor", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val userVendorRating: List<UserVendorRating> = listOf(),
)


enum class ServiceTypeEnum {
    PRESENTERS,
    SINGERS,
    DANCERS,
    GROUP,
    OPERATORS,
    PHOTOGRAPH,
    MOBILOGRAPH,
    TRANSPORT,
    DECORATORS,
    ANIMATORS,
    TECHNICAL_STAFF,
    SECURITY,
    SOUND_ENGINEERS,
    MEDICAL_WORKERS,
    STYLISTS,
    TECHNICAL_EQUIPMENT,
    HAIR_DRESSERS,
    CLOTHING_SUPPLIERS,
    FLOWER_SUPPLIERS
}
