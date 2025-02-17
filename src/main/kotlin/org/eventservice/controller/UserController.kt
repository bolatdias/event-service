package org.eventservice.controller

import org.eventservice.dto.UserResponse
import org.eventservice.model.User
import org.eventservice.repository.UserRepository
import org.eventservice.security.CurrentUser
import org.eventservice.security.JwtAuthenticationFilter
import org.eventservice.security.UserPrincipal
import org.eventservice.utils.UserMapper
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(
    private val userRepository: UserRepository
) {
    @QueryMapping
    fun getCurrentUser(@CurrentUser currentUser: UserPrincipal): User {
        return userRepository.findById(currentUser.id).orElseThrow { RuntimeException("User not found") }
    }
}