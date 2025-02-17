package org.eventservice.service

import jakarta.transaction.Transactional
import org.eventservice.dto.EventRequest
import org.eventservice.dto.EventResponse
import org.eventservice.model.Event
import org.eventservice.model.EventVendor
import org.eventservice.model.User
import org.eventservice.repository.*
import org.eventservice.utils.EventMapper
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

interface EventService {
    fun createEvent(request: EventRequest, user: User): EventResponse
    fun update(request: EventRequest, id: Long, user: User): EventResponse
    fun deleteEvent(id: Long, user: User)
    fun getEvent(id: Long): EventResponse
}


@Service
class EventServiceImpl(
    private val eventRepository: EventRepository,
    private val eventVendorRepository: EventVendorRepository,
    private val userVendorRepository: UserVendorRepository,
    private val userRepository: UserRepository,
    private val hallRepository: HallRepository
) : EventService {

    @Transactional
    override fun createEvent(request: EventRequest, user: User): EventResponse {
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

        return EventMapper.mapToResponse(eventRepository.save(event))
    }


    override fun update(request: EventRequest, id: Long, user: User): EventResponse {
        val event = eventRepository.findById(id).orElseThrow {
            RuntimeException("Event not found")
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

        return EventMapper.mapToResponse(eventRepository.save(event))
    }


    override fun deleteEvent(id: Long, user: User) {
        val event = eventRepository.findById(id).orElseThrow {
            RuntimeException("Event not found")
        }

        eventRepository.deleteById(id)
    }

    override fun getEvent(id: Long): EventResponse {
        val event = eventRepository.findById(id).orElseThrow {
            RuntimeException("Event not found")
        }
        return EventMapper.mapToResponse(event)
    }

}