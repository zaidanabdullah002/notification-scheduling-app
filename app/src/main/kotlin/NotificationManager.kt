import org.example.app.Notification
import org.example.app.NotificationSender
import org.example.app.Repository
import org.example.app.Type
import java.time.Duration
import java.time.LocalDateTime
import java.util.Observer
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class NotificationManager(private val repository: Repository,
                          private val notificationSenderFactory: NotificationSenderFactory) {
    val scheduler = Executors.newSingleThreadScheduledExecutor()

    fun saveNotification(notification: Notification) {
        repository.saveNotification(notification)
    }
    fun sendNotification(id:String) {
        val notification = repository.fetchNotification(id)
        val obj = notificationSenderFactory.getSender(notification.type)
        obj.sendNotification(notification)
        notification.notificationData.status = Status.SENT
    }
    fun scheduleNotification(notification: Notification) {
        saveNotification(notification)

        //get current time
        val current = LocalDateTime.now()
        val scheduledTime = notification.notificationData.scheduleTime

        val delayInMillis = Duration.between(current, scheduledTime).toMillis()

        if(delayInMillis <= 0){
            sendNotification(notification.id)
        }

        scheduler.schedule({ sendNotification(notification.id) },
            delayInMillis, TimeUnit.MILLISECONDS)

    }
}