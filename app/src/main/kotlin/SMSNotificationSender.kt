import org.example.app.Notification
import org.example.app.NotificationSender

class SMSNotificationSender : NotificationSender {
    override fun sendNotification(notification: Notification) {
        println("SMS Notification Sent successfully $notification")
    }
}