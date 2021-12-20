package com.meeweel.ciceronlogger.data.room

import androidx.room.Room
import com.meeweel.ciceronlogger.app.MainApp

object RoomEngine {
    private val database: DBStorage by lazy {
        Room.databaseBuilder(MainApp.ContextHolder.context, DBStorage::class.java, "github.db")
            .build()
    }

    fun create(): DBStorage = database
}