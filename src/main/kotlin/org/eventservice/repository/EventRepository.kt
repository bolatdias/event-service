package org.eventservice.repository

import org.eventservice.model.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface EventRepository : JpaRepository<Event, Long> {

}



interface EventVendorRepository : JpaRepository<EventVendor, Long>

interface UserVendorRepository : JpaRepository<UserVendor, Long> {
    @Query("select us from UserVendor us where us.id in :ids ")
    fun findAllByIds(ids: List<Long>): List<UserVendor>
}

interface PlaceRepository : JpaRepository<Place, Long> {
}

interface HallRepository : JpaRepository<Hall, Long>