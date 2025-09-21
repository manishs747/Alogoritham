package design_problems.notification_system;

public class EmailChannel implements Channel{


    @Override
    public boolean send(Notification notification) throws Exception {
        System.out.println("[Email] Sending to " + notification.getUserId() + ": " + notification.getMessage());
        return true; // simulate success
    }


}
