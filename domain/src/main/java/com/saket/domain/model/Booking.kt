package com.saket.domain.model

data class Booking(
    val bookingId: String,
    val source: String,
    val destination: String,
    val dateOfJourney: String,
    val passengerId: Int,
    val flightId: String
)
