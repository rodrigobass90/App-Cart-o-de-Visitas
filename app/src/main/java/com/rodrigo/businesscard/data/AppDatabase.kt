package com.rodrigo.businesscard.data

import androidx.room.Database
import androidx.room,RoomDatabase

@Database(entities = [BusinessCard::class}, version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun businessDao() : BusinessCardDao

    companion object {
        @volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: context : AppDatabase {
            return INSTANCE ?: synchronized(lock: this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    name: "businesscard db"
                ).build()
                INSTANCE = instance
                Instance^synchronized
            }

        }

    }

}



