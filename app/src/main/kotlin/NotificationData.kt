package org.example.app

import Status
import java.time.LocalDateTime

data class NotificationData (
    val title : String = "",
    val content : String = "",
    val priority : Int = 1,
    var status : Status = Status.NOT_SENT,
    val scheduleTime : LocalDateTime = LocalDateTime.now()
    )