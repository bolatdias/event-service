package org.eventservice.service

import org.eventservice.dto.EventRequest
import org.eventservice.model.Event
import org.eventservice.model.EventService
import org.eventservice.repository.*
import org.eventservice.utils.EventMapper
import org.springframework.stereotype.Service


@Service
class EventServiceImpl(
    private val eventRepository: EventRepository,
    private val eventServiceRepository: EventServiceRepository,
    private val userServiceRepository: UserServiceRepository,
    private val userRepository: UserRepository,
    private val hallRepository: HallRepository
) {

    fun createEvent(request: EventRequest): Event {
        val event = EventMapper.mapToModel(request)
        val userServices = userServiceRepository.findAllByIds(request.eventServices.map { it.id })
        val eventServices = userServices.map {
            EventService(
                event = event,
                userService = it,
                cost = it.averageCost ?: 0.0f
            )
        }
        eventServiceRepository.saveAll(eventServices)

        val user = userRepository.findById(1).orElseThrow { RuntimeException("User not found") }
        event.user = user

        val hall = hallRepository.findById(request.hallId).orElseThrow { RuntimeException("Place not found") }
        event.hall = hall

        return eventRepository.save(event)
    }


    fun update(request: EventRequest, id: Long): Event {
        val event = eventRepository.findById(id).orElseThrow {
            RuntimeException("Event not found")
        }

        val userServices = userServiceRepository.findAllByIds(request.eventServices.map { it.id })
        val eventServices = userServices.map {
            EventService(
                event = event,
                userService = it,
                cost = it.averageCost ?: 0.0f
            )
        }
        eventServiceRepository.saveAll(eventServices)

        val user = userRepository.findById(1).orElseThrow { RuntimeException("User not found") }
        event.user = user


        val hall = hallRepository.findById(request.hallId).orElseThrow { RuntimeException("Place not found") }
        event.hall = hall

        return eventRepository.save(event)
    }


    fun deleteEvent(id: Long) {
        eventRepository.deleteById(id)
    }

}