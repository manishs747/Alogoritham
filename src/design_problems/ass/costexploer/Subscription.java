package design_problems.ass.costexploer;

import java.time.LocalDate;
import java.util.Objects;

public class Subscription {
    private final Product product;
    private final LocalDate startDate;
    private final Plan plan;

    public Subscription(Product product, LocalDate startDate , Plan plan) {
        this.product = Objects.requireNonNull(product);
        this.startDate = Objects.requireNonNull(startDate);
        this.plan = plan;
    }

    public Product getProduct() { return product; }
    public LocalDate getStartDate() { return startDate; }

    public Plan getPlan(){
        return plan;
    }
}
