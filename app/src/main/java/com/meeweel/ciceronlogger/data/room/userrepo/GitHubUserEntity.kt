package com.meeweel.ciceronlogger.data.room.userrepo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "GitHubUserEntity")
data class GitHubUserEntity(

    @PrimaryKey(autoGenerate = true)
    val localId: Int,
    val login: String,
    val id: Int,
    val name: String,
    val html_url: String
)