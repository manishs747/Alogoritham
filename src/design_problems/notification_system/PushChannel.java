package design_problems.notification_system;

public class PushChannel implements  Channel{
    @Override
    public boolean send(Notification notification) throws Exception {
        System.out.println("[Push] Sending to " + notification.getUserId() + ": " + notification.getMessage());
        return true;
    }
}
