package org.eventservice.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException(
    private val resourceName: String?,
    private val fieldName: String?,
    private val fieldValue: Any?
) : RuntimeException("$resourceName not found with $fieldName : '$fieldValue'")