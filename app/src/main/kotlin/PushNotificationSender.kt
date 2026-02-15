import org.example.app.Notification
import org.example.app.NotificationSender

class PushNotificationSender : NotificationSender {
    override fun sendNotification(notification: Notification) {
        println("Push Notification Sent successfully $notification")
    }
}