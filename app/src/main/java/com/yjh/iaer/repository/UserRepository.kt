package com.yjh.iaer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.yjh.iaer.domain.User
import com.yjh.iaer.network.RetrofitApi
import com.yjh.iaer.room.db.IAERDatabase
import com.yjh.iaer.util.MD5Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val database: IAERDatabase) {

    val loginDatabaseUser: LiveData<User?> = Transformations.map(
        database.databaseDao.loadLoginUser()) {
        it?.asDomainUser()
    }

    suspend fun onLogin(username: String, password: String) {
        withContext(Dispatchers.IO) {
            try {
                val deferred = RetrofitApi.retrofitService.login(
                    username,
                    MD5Utils.getMD5ofStr(password).toLowerCase()
                )
                val response = deferred.await()
                if (response.isSuccessful) {
                    response.result?.let { user ->
                        database.databaseDao.resetLoginUser()
                        user.isInHistory = true
                        // should do in the django backend
                        user.isLogin = true
                        database.databaseDao.insertUser(user)
                    }
                } else {
                    // todo
                }
            } catch (e: Exception) {
                e.toString()
            }
        }
    }
}