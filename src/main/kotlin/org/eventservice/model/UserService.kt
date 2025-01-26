package org.eventservice.model

import jakarta.persistence.*


@Table
@Entity
class UserService(
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
    val serviceType: ServiceTypeEnum,

    @OneToMany(mappedBy = "userService", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val userServiceRating: List<UserServiceRating> = listOf(),
)


enum class ServiceTypeEnum {
    Presenters,
    Singers,
    Dancers,
    Group,
    Operators,
    Photograph,
    Mobilograph,
    Transport,
    Decorators,
    Animators,
    Technical_Staff,
    Security,
    Sound_Engineers,
    Medical_Workers,
    Stylists,
    Technical_Equipment,
    Hair_Dressers,
    Clothing_Suppliers,
    Flower_Suppliers
}