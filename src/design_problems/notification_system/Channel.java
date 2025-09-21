package design_problems.notification_system;


public interface Channel {
    boolean send(Notification notification) throws Exception;
}
