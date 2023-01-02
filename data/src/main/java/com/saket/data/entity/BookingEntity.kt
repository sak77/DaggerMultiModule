package com.saket.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saket.data.dao.BookingDao
import com.saket.domain.model.Booking

@Entity(tableName = BookingDao.BOOKING_ENTRIES)
class BookingEntity constructor(@Embedded val booking: Booking) {
    @PrimaryKey(autoGenerate = true)
    var pkId = 0
}