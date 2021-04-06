package com.yjh.iaer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.yjh.iaer.model.User
import com.yjh.iaer.room.db.IAERDatabase
import com.yjh.iaer.room.entity.DatabaseUser

class UserRepository(private val database: IAERDatabase) {

    val loginDatabaseUser: LiveData<User?> = Transformations.map(
        database.databaseDao.loadLoginUser()) {
        it?.asDomainUser()
    }

}