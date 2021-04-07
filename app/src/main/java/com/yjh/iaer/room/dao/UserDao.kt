package com.yjh.iaer.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yjh.iaer.room.entity.DatabaseUser

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: DatabaseUser)

    @Query("SELECT * FROM user_entity WHERE is_login = 1 LIMIT 1")
    fun loadLoginUser(): LiveData<DatabaseUser?>

    @Query("UPDATE user_entity SET is_login = 0, is_in_history = 0 WHERE is_login = 1 OR is_in_history = 1")
    fun resetLoginUser()
}