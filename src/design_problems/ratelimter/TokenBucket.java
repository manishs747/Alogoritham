package design_problems.ratelimter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;


public class TokenBucket {
    private int tokens;
    private long lastRefillTimestamp;
    private final RateLimiterConfig config;

    public TokenBucket(RateLimiterConfig config) {
        this.tokens = config.getMaxTokens();
        this.config = config;
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean tryConsume() {
        refill();
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        double secondsSinceLastRefill = (now - lastRefillTimestamp) / 1_000_000_000.0;
        int tokensToAdd = (int) (secondsSinceLastRefill * config.getRefillRatePerSecond());
        if (tokensToAdd > 0) {
            tokens = Math.min(config.getMaxTokens(), tokens + tokensToAdd);
            lastRefillTimestamp = now;
        }
    }
}
