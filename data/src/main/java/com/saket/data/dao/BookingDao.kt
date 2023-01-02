package com.saket.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.saket.data.entity.BookingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookingDao {

    companion object {
        const val BOOKING_ENTRIES = "booking_entries"
    }

    @Query("SELECT * FROM $BOOKING_ENTRIES")
    fun getAllBookings(): Flow<List<BookingEntity>>

    @Insert
    fun addBooking(booking: BookingEntity)

    @Query("DELETE FROM $BOOKING_ENTRIES WHERE bookingId = :bookingId")
    fun deleteBooking(bookingId: String)

}