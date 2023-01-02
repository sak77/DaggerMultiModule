package com.saket.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saket.data.dao.FlightDao
import com.saket.domain.model.Flight

@Entity(tableName = FlightDao.FLIGHT_ENTRIES)
class FlightEntity constructor(@Embedded val flight: Flight) {
    @PrimaryKey(autoGenerate = true)
    var pkId = 0
}