package org.example.app

import java.time.LocalDateTime

class Repository {
    val notifications = mutableMapOf<String,Notification>()
    val schedule = mutableMapOf<LocalDateTime, MutableList<String>>()
    fun saveNotification(notification: Notification) {
        notifications[notification.id] = notification
        schedule[notification.notificationData.scheduleTime]?.add(notification.id)
    }
    fun fetchNotification(id: String): Notification {
        val default = Notification("",Type.SMS,"", NotificationData())
        return notifications[id] ?: default
    }
    fun fetchNotificationsByTime(time : LocalDateTime): List<String> {
        return schedule[time] ?: listOf()
    }
}