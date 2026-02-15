package org.example.app

import NotificationManager
import NotificationSenderFactory
import org.example.utils.Printer
import java.time.LocalDateTime

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val repository = Repository()
    val factory = NotificationSenderFactory()
    val notificationManager = NotificationManager(
        repository,
        factory,
    )

    val notification1 = Notification("1",Type.PUSH,"user1",
        NotificationData("zomato","your food got delivered",0))
    val notification2 = Notification("2",Type.SMS,"user2",
        NotificationData("swiggy","your food got delivered",3))
    val notification3 = Notification("3",Type.EMAIL,"user3",
        NotificationData("zomato","your food got delivered",2,
            scheduleTime = LocalDateTime.now().plusSeconds(6)))

    notificationManager.saveNotification(notification1)
    notificationManager.saveNotification(notification2)

    //schedule notification after 6 seconds
    notificationManager.scheduleNotification(notification3)

    notificationManager.sendNotification("1")
    notificationManager.sendNotification("2")



}
