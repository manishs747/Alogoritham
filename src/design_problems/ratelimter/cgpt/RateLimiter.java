package design_problems.ratelimter.cgpt;

public interface RateLimiter {
    boolean allowRequest(String userId);
}
