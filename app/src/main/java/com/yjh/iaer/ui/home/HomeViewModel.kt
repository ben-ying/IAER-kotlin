package com.yjh.iaer.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.yjh.iaer.repository.UserRepository
import com.yjh.iaer.room.db.IAERDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class HomeViewModel(application: Application) : AndroidViewModel(application)  {

    private val database = IAERDatabase.getInstance(application)
    private val repository = UserRepository(database)
    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    val loginUser = repository.loginDatabaseUser
}