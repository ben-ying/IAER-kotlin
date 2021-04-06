package com.yjh.iaer.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.yjh.iaer.room.entity.DatabaseUser

@Dao
interface UserDao {

    @Query("SELECT * FROM user_entity WHERE is_login = 1 LIMIT 1")
    fun loadLoginUser(): LiveData<DatabaseUser?>

}