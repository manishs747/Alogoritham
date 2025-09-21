package design_problems.notification_system;

public class SMSChannel implements Channel{
    @Override
    public boolean send(Notification notification) throws Exception {
        System.out.println("[SMS] Sending to " + notification.getUserId() + ": " + notification.getMessage());
        return true;
    }
}
