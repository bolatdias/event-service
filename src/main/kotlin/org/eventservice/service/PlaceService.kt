package org.eventservice.service

import jakarta.transaction.Transactional
import org.eventservice.dto.EventRequest
import org.eventservice.dto.EventResponse
import org.eventservice.dto.PlaceResponse
import org.eventservice.dto.UserVendorResponse
import org.eventservice.model.Event
import org.eventservice.model.EventVendor
import org.eventservice.model.User
import org.eventservice.model.UserVendor
import org.eventservice.repository.*
import org.eventservice.utils.EventMapper
import org.eventservice.utils.PlaceMapper
import org.eventservice.utils.UserVendorMapper
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

interface PlaceService {
    fun getPopularPlaces(limit: Long): List<PlaceResponse>
}


@Service
class PlaceServiceImpl (
    private val placeRepository: PlaceRepository
) : PlaceService {

    override fun getPopularPlaces(limit: Long): List<PlaceResponse> {
        return placeRepository.findAll().map {
            PlaceMapper.mapToResponse(it)
        }
    }
}