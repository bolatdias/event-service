package org.eventservice.repository

import org.eventservice.model.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface EventRepository : JpaRepository<Event, Long> {

}

interface UserRepository : JpaRepository<User, Long> {
}

interface EventServiceRepository : JpaRepository<EventService, Long>

interface UserServiceRepository : JpaRepository<UserService, Long> {
    @Query("select us from UserService us where us.id in :ids ")
    fun findAllByIds(ids: List<Long>): List<UserService>
}

interface PlaceRepository : JpaRepository<Place, Long> {
}

interface HallRepository : JpaRepository<Hall, Long>