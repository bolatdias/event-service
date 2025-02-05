package org.eventservice.repository


import org.eventservice.model.Role
import org.eventservice.model.RoleName
import org.eventservice.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String?): Optional<User>

    fun findByUsernameOrEmail(username: String?, email: String?): Optional<User>

    fun findByIdIn(userIds: List<Long>): List<User>

    fun findByUsername(username: String?): Optional<User>

    fun existsByUsername(username: String?): Boolean

    fun existsByEmail(email: String?): Boolean
}



interface RoleRepository : JpaRepository<Role, Long> {
    fun findByName(roleName: RoleName?): Optional<Role>
}