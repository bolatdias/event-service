package org.eventservice.security


import org.eventservice.exception.ResourceNotFoundException
import org.eventservice.model.User
import org.eventservice.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomUserDetailsService(
    var userRepository: UserRepository
) : UserDetailsService {

    @Transactional
    override fun loadUserByUsername(usernameOrEmail: String): UserDetails {
        val user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
            .orElseThrow { UsernameNotFoundException("UserController not found with username or email : $usernameOrEmail") }

        return UserPrincipal.create(user)
    }

    @Transactional
    fun loadUserById(id: Long): UserDetails {
        val user: User = userRepository.findById(id).orElseThrow {
            ResourceNotFoundException(
                "UserController",
                "id",
                id
            )
        }

        return UserPrincipal.create(user)
    }
}