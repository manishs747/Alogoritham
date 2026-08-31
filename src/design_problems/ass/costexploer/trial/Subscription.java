package design_problems.ass.costexploer.trial;

import design_problems.ass.costexploer.Product;

import java.time.LocalDate;

public class Subscription {
    private final Product product;
    private final Plan plan;
    private final LocalDate startDate;
    private final LocalDate endDate; // optional (e.g., trial expiry, cancelled subs)
    private final Plan planAfterTrial; // only used if plan == TRIAL

    public Subscription(Product product, Plan plan, LocalDate startDate, LocalDate endDate, Plan planAfterTrial) {
        this.product = product;
        this.plan = plan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.planAfterTrial = planAfterTrial;
    }

    public Product getProduct() { return product; }
    public Plan getPlan() { return plan; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public Plan getPlanAfterTrial() { return planAfterTrial; }
}
