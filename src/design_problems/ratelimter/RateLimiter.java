package design_problems.ratelimter;

public interface RateLimiter {
    boolean allowRequest(String userId);
}
