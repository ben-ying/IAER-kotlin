package com.yjh.iaer.ui.account

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.yjh.iaer.repository.UserRepository
import com.yjh.iaer.room.db.IAERDatabase
import kotlinx.coroutines.*

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val database = IAERDatabase.getInstance(application)
    private val repository = UserRepository(database)
    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)
    val loginUser = repository.loginDatabaseUser

    fun onLogin(username: String, password: String) {
        coroutineScope.launch {
            repository.onLogin(username, password)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}