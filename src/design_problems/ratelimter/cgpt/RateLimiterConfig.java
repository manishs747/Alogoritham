package design_problems.ratelimter.cgpt;

public class RateLimiterConfig {

    private final int maxTokens;
    private final int refillRatePerSecond;

    public RateLimiterConfig(int maxTokens, int refillRatePerSecond) {
        this.maxTokens = maxTokens;
        this.refillRatePerSecond = refillRatePerSecond;
    }

    public int getMaxTokens() { return maxTokens; }
    public int getRefillRatePerSecond() { return refillRatePerSecond; }

}
