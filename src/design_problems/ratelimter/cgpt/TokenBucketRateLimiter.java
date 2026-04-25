package design_problems.ratelimter.cgpt;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter implements RateLimiter {
    private final Map<String, TokenBucket> userBuckets = new ConcurrentHashMap<>();
    private final RateLimiterConfig config;

    public TokenBucketRateLimiter(RateLimiterConfig config) {
        this.config = config;
    }

    @Override
    public boolean allowRequest(String userId) {
        TokenBucket bucket = userBuckets.computeIfAbsent(userId, id -> new TokenBucket(config));
        return bucket.tryConsume();
    }
}
