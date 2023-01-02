package com.saket.data

import com.saket.data.db.BookingDB
import com.saket.data.entity.BookingEntity
import com.saket.data.entity.FlightEntity
import com.saket.data.entity.LocationEntity
import com.saket.data.entity.UserEntity
import com.saket.domain.model.Booking
import com.saket.domain.model.Flight
import com.saket.domain.model.Location
import com.saket.domain.model.User
import com.saket.domain.repository.IBookingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BookingRepository(private val bookingDB: BookingDB) : IBookingRepository {
    override fun getAllBookings(): Flow<List<Booking>> =
        bookingDB.bookingDao().getAllBookings().map { list ->
            list.map {
                it.booking
            }
        }

    override fun addBooking(booking: Booking) =
        bookingDB.bookingDao().addBooking(BookingEntity(booking))

    override fun getAllUsers(): Flow<List<User>> =
        bookingDB.userDao().getAllUsers().map { list ->
            list.map {
                it.user
            }
        }

    override fun addUser(user: User) {
        return bookingDB.userDao().addUser(UserEntity(user))
    }

    override fun authenticateUser(name: String, password: String): User? {
        return bookingDB.userDao().authenticateUser(name, password)?.user
    }

    override fun getAllFlights(): List<Flight> =
        bookingDB.flightDao().getAllFlights().map {
            it.flight
        }

    override fun addFlight(flight: Flight) =
        bookingDB.flightDao().addFlight(FlightEntity(flight))

    override fun removeAllFlights() =
        bookingDB.flightDao().clearFlights()

    override fun getAllLocations(): List<Location> =
        bookingDB.locationDao().getAllLocations().map {
            it.location
        }

    override fun addLocation(location: Location) =
        bookingDB.locationDao().addLocation(LocationEntity(location))

    override fun clearAllLocations() =
        bookingDB.locationDao().clearAllLocations()
}