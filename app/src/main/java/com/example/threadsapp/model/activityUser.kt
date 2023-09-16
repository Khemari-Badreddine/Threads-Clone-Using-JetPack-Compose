package com.example.threadsapp.model

data class activityUser(
    val pfp: Int,
    val userName: String,
    val time: String,
    val type: Int, // 0-> followed you, 1->follow request
    val verified: Boolean

)