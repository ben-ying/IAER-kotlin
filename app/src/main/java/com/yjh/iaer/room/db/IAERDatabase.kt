package com.yjh.iaer.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yjh.iaer.room.dao.UserDao
import com.yjh.iaer.room.entity.DatabaseUser

@Database(entities = [DatabaseUser::class], version = 1, exportSchema = false)
abstract class IAERDatabase : RoomDatabase() {

    abstract val databaseDao: UserDao

    companion object {
        @Volatile
        private var INSTANCE: IAERDatabase? = null

        fun getInstance(context: Context): IAERDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        IAERDatabase::class.java,
                        "iaer_database")
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}