package com.example.bai29api

import com.google.gson.annotations.SerializedName


data class User(
    val id: Int,
    @SerializedName("title")
    val name: String,
    val userId: Int,
    val body: String
)