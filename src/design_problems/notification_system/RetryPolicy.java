package design_problems.notification_system;

public class RetryPolicy {
    private final int maxRetries;
    private final long backoffMillis;

    public RetryPolicy(int maxRetries, long backoffMillis) {
        this.maxRetries = maxRetries;
        this.backoffMillis = backoffMillis;
    }

    public boolean retry(Channel channel, Notification notification) {
        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                if (channel.send(notification)) return true;
                Thread.sleep(backoffMillis * attempt); // exponential backoff
            } catch (Exception e) {
                System.err.println("Retry " + attempt + " failed: " + e.getMessage());
            }
        }
        return false;
    }
}
