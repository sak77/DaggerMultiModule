package com.saket.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.saket.data.entity.LocationEntity

@Dao
interface LocationDao {
    companion object {
        const val LOCATION_ENTRIES = "location_entries"
    }

    @Query("SELECT * FROM $LOCATION_ENTRIES")
    fun getAllLocations(): List<LocationEntity>

    @Insert
    fun addLocation(location: LocationEntity)

    @Query("DELETE FROM $LOCATION_ENTRIES WHERE locationId = :locationId")
    fun deleteLocation(locationId: String)

    @Query("DELETE FROM $LOCATION_ENTRIES")
    fun clearAllLocations()
}