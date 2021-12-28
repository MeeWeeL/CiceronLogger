package com.meeweel.ciceronlogger.data.forretrofit.userrepo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubRepoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("html_url")
    val html_url: String = ""
) : Parcelable