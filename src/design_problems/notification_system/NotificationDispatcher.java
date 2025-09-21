package design_problems.notification_system;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class NotificationDispatcher  implements  Runnable{

    private final BlockingQueue<Notification> queue;
    private final RetryPolicy retryPolicy;

    public NotificationDispatcher(BlockingQueue<Notification> queue, RetryPolicy retryPolicy) {
        this.queue = queue;
        this.retryPolicy = retryPolicy;
    }

    private Channel getChannel(ChannelType type) {
        return switch (type) {
            case EMAIL -> new EmailChannel();
            case SMS -> new SMSChannel();
            case PUSH -> new PushChannel();
        };
    }

    @Override
    public void run() {
        while (true) {
            try {
                Notification notification = queue.poll(1, TimeUnit.SECONDS);
                if (notification != null) {
                    Channel channel = getChannel(notification.getChannelType());
                    boolean success = retryPolicy.retry(channel, notification);
                    if (!success) {
                        sendToDLQ(notification);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void sendToDLQ(Notification notification) {
        System.err.println("Moved to DLQ: " + notification.getMessage());
        // Could push to a dedicated DLQ topic for later analysis
    }
}
