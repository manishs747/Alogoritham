package design_problems.notification_system;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class NotificationServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Notification> queue = new PriorityBlockingQueue<>();
        RetryPolicy retryPolicy = new RetryPolicy(3, 200);

        NotificationDispatcher dispatcher = new NotificationDispatcher(queue, retryPolicy);
        Thread dispatcherThread = new Thread(dispatcher);
        dispatcherThread.start();

        queue.put(new Notification("user1", "Payment Successful", ChannelType.EMAIL, Priority.HIGH));
        queue.put(new Notification("user2", "Order Shipped", ChannelType.SMS, Priority.MEDIUM));
        queue.put(new Notification("user3", "Welcome!", ChannelType.PUSH, Priority.LOW));
    }
}
