import org.example.app.Notification
import org.example.app.NotificationSender


class EmailNotificationSender : NotificationSender {
    override fun sendNotification(notification: Notification) {
        println("Email Notification Sent successfully $notification")
    }
}