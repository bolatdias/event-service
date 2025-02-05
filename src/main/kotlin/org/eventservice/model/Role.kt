package org.eventservice.model

import jakarta.persistence.*


@Entity
@Table(name = "roles")
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    var name: RoleName? = null
)

enum class RoleName {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_COMPANY
}