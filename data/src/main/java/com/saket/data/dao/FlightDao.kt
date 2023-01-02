package com.saket.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.saket.data.entity.FlightEntity

@Dao
interface FlightDao {

    companion object {
        const val FLIGHT_ENTRIES = "flight_entries"
    }

    @Query("SELECT * FROM $FLIGHT_ENTRIES")
    fun getAllFlights(): List<FlightEntity>

    @Insert
    fun addFlight(flight: FlightEntity)

    @Query("DELETE FROM $FLIGHT_ENTRIES WHERE airlineId = :flightId")
    fun removeFlight(flightId: String)

    @Query("DELETE FROM $FLIGHT_ENTRIES")
    fun clearFlights()

}