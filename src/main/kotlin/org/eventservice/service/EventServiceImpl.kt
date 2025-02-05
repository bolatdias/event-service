package org.eventservice.service

import jakarta.transaction.Transactional
import org.eventservice.dto.EventRequest
import org.eventservice.model.Event
import org.eventservice.model.EventVendor
import org.eventservice.model.User
import org.eventservice.repository.*
import org.eventservice.utils.EventMapper
import org.springframework.stereotype.Service


@Service
class EventServiceImpl(
    private val eventRepository: EventRepository,
    private val eventVendorRepository: EventVendorRepository,
    private val userVendorRepository: UserVendorRepository,
    private val userRepository: UserRepository,
    private val hallRepository: HallRepository
) {

    @Transactional
    fun createEvent(request: EventRequest, user: User): Event {
        var event = EventMapper.mapToModel(request)

        val user = userRepository.findById(1).orElseThrow { RuntimeException("User not found") }
        event.user = user

        val hall = hallRepository.findById(request.hallId).orElseThrow { RuntimeException("Place not found") }
        event.hall = hall

        val userServices = userVendorRepository.findAllByIds(request.eventServices.map { it.id })
        event.eventServices = userServices.map {
            EventVendor(
                event = event,
                userVendor = it,
                cost = it.averageCost ?: 0.0f
            )
        }

        return eventRepository.save(event)
    }


    fun update(request: EventRequest, id: Long, user: User): Event {
        val event = eventRepository.findById(id).orElseThrow {
            RuntimeException("Event not found")
        }

        if (event.user != user) {
            throw RuntimeException("User don't have permision")
        }

        val userServices = userVendorRepository.findAllByIds(request.eventServices.map { it.id })
        val eventServices = userServices.map {
            EventVendor(
                event = event,
                userVendor = it,
                cost = it.averageCost ?: 0.0f
            )
        }
        eventVendorRepository.saveAll(eventServices)

        val user = userRepository.findById(1).orElseThrow { RuntimeException("User not found") }
        event.user = user


        val hall = hallRepository.findById(request.hallId).orElseThrow { RuntimeException("Place not found") }
        event.hall = hall

        return eventRepository.save(event)
    }


    fun deleteEvent(id: Long, user: User) {
        val event = eventRepository.findById(id).orElseThrow {
            RuntimeException("Event not found")
        }

        if (event.user != user) {
            throw RuntimeException("User don't have permision")
        }

        eventRepository.deleteById(id)
    }

}