package org.example.app

data class Notification(
    val id: String,
    val type : Type,
    val recipient : String,
    val notificationData : NotificationData
)