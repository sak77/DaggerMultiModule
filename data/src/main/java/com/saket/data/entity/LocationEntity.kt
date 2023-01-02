package com.saket.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saket.data.dao.LocationDao
import com.saket.domain.model.Location

@Entity(tableName = LocationDao.LOCATION_ENTRIES)
class LocationEntity constructor(@Embedded val location: Location) {
    @PrimaryKey(autoGenerate = true)
    var pkId = 0
}