package org.eventservice.security


import org.eventservice.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class UserPrincipal(
    val id: Long,
    private val username: String,
    val email: String?,
    private val password: String,
    private val authorities: Collection<GrantedAuthority>
) : UserDetails {
    private val accountNonLocked = true

    override fun getUsername(): String {
        return username
    }

    override fun getPassword(): String {
        return password
    }

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authorities
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return accountNonLocked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as UserPrincipal
        return id == that.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }

    companion object {
        fun create(user: User): UserPrincipal {
            val authorities: List<GrantedAuthority> = user.roles.map { role ->
                SimpleGrantedAuthority(
                    role.name?.name
                )
            }.toList()

            return UserPrincipal(
                user.id,
                user.username,
                user.email,
                user.password,
                authorities
            )
        }
    }
}