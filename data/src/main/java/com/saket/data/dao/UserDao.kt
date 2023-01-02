package com.saket.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.saket.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    companion object {
        const val USER_ENTRIES = "user_entries"
    }

    @Query("SELECT * FROM $USER_ENTRIES")
    fun getAllUsers(): Flow<List<UserEntity>>

    @Insert
    fun addUser(user: UserEntity)

    @Query("DELETE FROM $USER_ENTRIES WHERE userId = :userId")
    fun deleteUser(userId: Int): Int

    @Query("SELECT * FROM $USER_ENTRIES WHERE name = :name AND password = :password")
    fun authenticateUser(name: String, password: String): UserEntity?
}