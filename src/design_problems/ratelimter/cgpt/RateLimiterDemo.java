package design_problems.ratelimter.cgpt;

public class RateLimiterDemo {
    public static void main(String[] args) throws InterruptedException {
        RateLimiterConfig config = new RateLimiterConfig(5, 5); // 5 tokens, 5 req/sec
        RateLimiter rateLimiter = new TokenBucketRateLimiter(config);

        String userId = "user123";

        for (int i = 0; i < 10; i++) {
            boolean allowed = rateLimiter.allowRequest(userId);
            System.out.println("Request " + i + " allowed: " + allowed);
            Thread.sleep(100);
        }
    }
}
