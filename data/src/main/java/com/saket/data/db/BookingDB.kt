package com.saket.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.saket.data.dao.BookingDao
import com.saket.data.dao.FlightDao
import com.saket.data.dao.LocationDao
import com.saket.data.dao.UserDao
import com.saket.data.entity.BookingEntity
import com.saket.data.entity.FlightEntity
import com.saket.data.entity.LocationEntity
import com.saket.data.entity.UserEntity

@Database(
    entities = [BookingEntity::class, FlightEntity::class, LocationEntity::class, UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class BookingDB : RoomDatabase() {
    abstract fun bookingDao(): BookingDao
    abstract fun flightDao(): FlightDao
    abstract fun locationDao(): LocationDao
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: BookingDB? = null

        fun getInstance(context: Context): BookingDB =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context): BookingDB {
            return Room.databaseBuilder(context, BookingDB::class.java, "Booking.db")
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                        }
                    }
                )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}