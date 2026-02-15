import org.example.app.NotificationSender
import org.example.app.Type

class NotificationSenderFactory {

    companion object {
        private val factoryMap = mutableMapOf<Type, NotificationSender>()
    }
    constructor() {
        factoryMap[Type.SMS] = SMSNotificationSender()
        factoryMap[Type.EMAIL] = EmailNotificationSender()
        factoryMap[Type.PUSH] = PushNotificationSender()
    }
    fun getSender(notificationType : Type): NotificationSender {
        return factoryMap[notificationType]!!
    }

}