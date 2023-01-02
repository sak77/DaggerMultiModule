package com.saket.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saket.data.dao.UserDao
import com.saket.domain.model.User

@Entity(tableName = UserDao.USER_ENTRIES)
class UserEntity constructor(@Embedded val user: User) {
    @PrimaryKey(autoGenerate = true)
    var pkId = 0
}