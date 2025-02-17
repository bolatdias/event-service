package org.eventservice.scalar

import graphql.language.StringValue
import graphql.schema.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException


object LocalDateScalar {
    private val FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    fun createLocalDateScalar(): GraphQLScalarType {
        return GraphQLScalarType.newScalar()
            .name("LocalDate")
            .description("Custom scalar for handling LocalDate in format 'yyyy-MM-dd'")
            .coercing(object : Coercing<LocalDate, String> {
                override fun serialize(dataFetcherResult: Any): String {
                    if (dataFetcherResult is LocalDate) {
                        return FORMATTER.format(dataFetcherResult)
                    }
                    throw CoercingSerializeException("Expected a LocalDate object.")
                }

                override fun parseValue(input: Any): LocalDate {
                    if (input is String) {
                        try {
                            return LocalDate.parse(input, FORMATTER)
                        } catch (e: DateTimeParseException) {
                            throw CoercingParseValueException(
                                "Invalid LocalDate format. Expected 'yyyy-MM-dd'.", e
                            )
                        }
                    }
                    throw CoercingParseValueException("Expected a String value for LocalDate.")
                }

                override fun parseLiteral(input: Any): LocalDate {
                    if (input is StringValue) {
                        try {
                            return LocalDate.parse(input.value, FORMATTER)
                        } catch (e: DateTimeParseException) {
                            throw CoercingParseLiteralException(
                                "Invalid LocalDate literal. Expected 'yyyy-MM-dd'.", e
                            )
                        }
                    }
                    throw CoercingParseLiteralException("Expected a StringValue for LocalDate literal.")
                }
            }).build()
    }
}