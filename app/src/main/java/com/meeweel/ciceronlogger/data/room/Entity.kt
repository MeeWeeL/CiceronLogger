package com.meeweel.ciceronlogger.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Entity(

    @PrimaryKey(autoGenerate = true)
    val localId: Int,
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val url: String
)