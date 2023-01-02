package com.saket.domain.repository

import com.saket.domain.model.Booking
import com.saket.domain.model.Flight
import com.saket.domain.model.Location
import com.saket.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IBookingRepository {

    fun getAllBookings(): Flow<List<Booking>>

    fun addBooking(booking: Booking)

    fun getAllUsers(): Flow<List<User>>

    fun addUser(user: User)

    fun authenticateUser(name: String, password: String): User?

    fun getAllFlights(): List<Flight>

    fun addFlight(flight: Flight)

    fun removeAllFlights()

    fun getAllLocations(): List<Location>

    fun addLocation(location: Location)

    fun clearAllLocations()

}